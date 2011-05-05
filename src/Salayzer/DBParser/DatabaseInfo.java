package Salayzer.DBParser;

import Salayzer.SQLParser.SQLError;
import Zql.ZConstant;
import Zql.ZFromItem;

import java.sql.*;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: amirraminfar2
 * Date: Apr 11, 2007
 * Time: 2:20:43 PM
 */
public class DatabaseInfo {
    private String jdbc_url, user, pass;
    private Map<String, ColumnInfo> db_info;
    private List<String> tables;

    public DatabaseInfo(String host, String user, String pass, String db) {
        this.jdbc_url = "jdbc:mysql://" + host + ":3306/" + db;
        this.user = user;
        this.pass = pass;
        this.parseDatabaseInfo();
    }


    public void parseDatabaseInfo() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbc_url, user, pass);
            Statement stmt = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SHOW tables");
            db_info = new Hashtable<String, ColumnInfo>();
            tables = new Vector<String>();
            while (rs.next()) {

                ResultSet rs2 = stmt2.executeQuery("SHOW COLUMNS FROM " + rs.getString(1));
                while (rs2.next()) {
                    tables.add(rs.getString(1));
                    ColumnInfo columnInfo = new ColumnInfo(rs2.getString("Field"));
                    columnInfo.setTable(rs.getString(1));
                    columnInfo.parseColumnType(rs2.getString("Type"));
                    db_info.put(rs.getString(1) + "." + rs2.getString("Field"), columnInfo);
                }
            }
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException("There was a problem connecting to the database. " +
                    "Please make sure your database is running and that your crendentials are correct.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map<String, ColumnInfo> getDatabaseInfo() {
        return db_info;
    }

    public boolean tableExists(String table) {
        if (tables != null) {
            return tables.contains(table);
        } else {
            throw new RuntimeException("Database has not been parsed yet");
        }
    }

    public boolean columnExists(String t, String c) {
        if (db_info != null) {
            return db_info.containsKey(t + "." + c);
        } else {
            throw new RuntimeException("Database has not been parsed yet");
        }
    }

    public boolean columnExists(String tc) {
        if (db_info != null) {
            return db_info.containsKey(tc);
        } else {
            throw new RuntimeException("Database has not been parsed yet");
        }
    }

    public ColumnInfo findColumn(ZConstant left, Vector<ZFromItem> from) throws SQLError {
        ColumnInfo col = null;
        for (ZFromItem table : from) {
            if (columnExists(table.getTable(), left.getValue())) {
                if (col == null) {
                    col = db_info.get(table.getTable() + "." + left.getValue());
                } else {
                    throw new SQLError(left + " causes an ambiguity problem");
                }
            }
        }

        return col;

    }
}
