package Salayzer.SQLParser;

import Salayzer.DBParser.ColumnInfo;
import Salayzer.DBParser.DatabaseInfo;
import Salayzer.DBParser.Info;
import Zql.*;

import java.io.ByteArrayInputStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: amirraminfar2
 * Date: Apr 13, 2007
 * Time: 3:44:30 PM
 */
public class SQLStatement {
    private final static int int_offset = 100000000;
    public final static String int_type = "java_var_int_";
    public final static String string_type = "java_var_string_";
    private String original_statement;
    private ZqlParser parser;
    private ZQuery query;
    private DatabaseInfo db_info;
    private Map<String, String> var_lookup;


    public SQLStatement() {
        parser = new ZqlParser();
    }

    public SQLStatement(String q) throws ParseException {
        this();
        parseQuery(q);
    }

    public void parseQuery(String q) throws ParseException {
        this.original_statement = q;
        if (!q.endsWith(";")) {
            q += ";";
        }
        q = replaceJavaVars(q);
        parser.initParser(new ByteArrayInputStream(q.getBytes()));
        ZStatement statement = parser.readStatement();
        query = (ZQuery) statement;
    }

    public String replaceJavaVars(String s) {
        var_lookup = new Hashtable<String, String>();
        int inc = int_offset + 0;
        Pattern pattern = Pattern.compile(int_type + "[^\\s;,]+");
        while (s.contains(int_type)) {
            inc += 10;
            Matcher m = pattern.matcher(s);
            m.find();
            var_lookup.put(String.valueOf(inc), m.group().replace(int_type, ""));
            s = m.replaceFirst(String.valueOf(inc));
        }

        pattern = Pattern.compile(string_type + "[^\\s;,]+");
        inc = 0;
        while (s.contains(string_type)) {
            inc += 1;
            Matcher m = pattern.matcher(s);
            m.find();
            String t = "'temp_str" + String.valueOf(inc) + "'";
            var_lookup.put(t, m.group().replace(string_type, ""));
            s = m.replaceFirst(t);
        }

        return s;
    }


    public void setDb_info(DatabaseInfo db_info) {
        this.db_info = db_info;
    }

    public void validateTables() throws SQLError {
        List<ZFromItem> tables = (Vector<ZFromItem>) query.getFrom();
        for (ZFromItem table : tables) {
            if (!db_info.tableExists(table.getTable())) {
                throw new SQLError(table + " does not exists in database");
            }
        }
    }

    public void validateColumns() throws SQLError {
        List<ZFromItem> tables = (Vector<ZFromItem>) query.getFrom();
        List<ZSelectItem> columns = (Vector<ZSelectItem>) query.getSelect();
        for (ZFromItem table : tables) {
            for (ZSelectItem column : columns) {
                if (!db_info.columnExists((column.getTable() == null || column.getTable().equals("")) ? table.getTable() : column.getTable(), column.getColumn())) {
                    throw new SQLError("Column \"" + column + "\" does not exist in " + table);
                }
            }
        }
    }

    private boolean validateExp(ZConstant left, ZConstant right, Vector<ZFromItem> from) throws SQLError {

        if (left.getType() == ZConstant.COLUMNNAME) {
            ColumnInfo column = db_info.findColumn(left, from);
            if (column.getType() == Info.var_type.INTEGER) {
                return right.getType() == ZConstant.NUMBER;
            } else if (column.getType() == Info.var_type.STRING) {
                return right.getType() == ZConstant.STRING;
            } else if (column.getType() == Info.var_type.UNKNOWN) {
                throw new SQLError("I don't know what type of column " + column.getName() + " is.");
            }

        } else if (right.getType() == ZConstant.COLUMNNAME) {
            ColumnInfo column = db_info.findColumn(right, from);

            if (column.getType() == Info.var_type.INTEGER) {
                return left.getType() == ZConstant.NUMBER;
            } else if (column.getType() == Info.var_type.STRING) {
                return left.getType() == ZConstant.STRING;
            } else if (column.getType() == Info.var_type.UNKNOWN) {
                throw new SQLError("I don't know what type of column " + column.getName() + " is.");
            }
        } else {
            throw new SQLError("There must exist at least one column name.");
        }

        return false;
    }

    public void validteWhere() throws SQLError {
        ZExpression exp = (ZExpression) query.getWhere();
        if (exp != null) {
            List<ZExpression> expressions = (Vector<ZExpression>) exp.getOperands();
            if (expressions.get(0) instanceof ZExpression) {
                for (ZExpression s : expressions) {
                    validateExpression(s);
                }
            } else {
                validateExpression(exp);
            }
        }
    }

    private void validateExpression(ZExpression s) throws SQLError {
        if (!validateExp((ZConstant) s.getOperand(0), (ZConstant) s.getOperand(1), query.getFrom())) {
            String temp = s.toString();
            if (var_lookup.containsKey(s.getOperand(0).toString())) {
                temp = temp.replaceAll(s.getOperand(0).toString(), var_lookup.get(s.getOperand(0).toString()));
            } else if (var_lookup.containsKey(s.getOperand(1).toString())) {
                temp = temp.replaceAll(s.getOperand(1).toString(), var_lookup.get(s.getOperand(1).toString()));
            }

            throw new SQLError("Type mismatch for expression: " + temp);
        }
    }

    public void validateAll() throws SQLError {
        this.validateTables();
        this.validateColumns();
        this.validteWhere();
    }

}
