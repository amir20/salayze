package Salayzer.DBParser;

/**
 * Created by IntelliJ IDEA.
 * User: amirraminfar2
 * Date: Apr 11, 2007
 * Time: 8:40:19 PM
 */
public class ColumnInfo extends Info {
    private int length;
    private String table;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table.toUpperCase();
    }

    public ColumnInfo() {
    }

    public ColumnInfo(String n) {
        super(n);
    }


    public Info.var_type getType() {
        return type;
    }

    public void setType(Info.var_type type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void parseColumnType(String s) {
        if (s.toLowerCase().startsWith("varchar")) {
            this.type = Info.var_type.STRING;
            this.length = Integer.parseInt(s.toLowerCase().replace("varchar", "").replace("(", "").replace(")", ""));
        } else if (s.toLowerCase().startsWith("int")
                || s.toLowerCase().startsWith("smallint")
                || s.toLowerCase().startsWith("bigint")) {
            this.type = Info.var_type.INTEGER;
        } else {
            this.type = Info.var_type.UNKNOWN;
        }
    }

    public String toString() {
        return "[Salyze.DBParser.ColumnInfo] \n: name -- " + this.name + "\n: type -- " + this.type + "\n: table -- " + this.table + "\n: length -- " + this.length + "\n\n";
    }
}
