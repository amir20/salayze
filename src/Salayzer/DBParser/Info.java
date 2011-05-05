package Salayzer.DBParser;

/**
 * Created by IntelliJ IDEA.
 * User: amirraminfar2
 * Date: Apr 11, 2007
 * Time: 8:52:41 PM
 */
public class Info {
    public enum var_type {
        INTEGER, STRING, UNKNOWN
    }


    protected var_type type;
    protected String name;

    public Info() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public Info(String n) {
        this.setName(n);
    }

    public var_type getType() {
        return type;
    }

    public void setType(var_type type) {
        this.type = type;
    }

    public boolean equals(Object object) {
        return (object instanceof Info) && (this.type == ((Info) object).type);
    }
}
