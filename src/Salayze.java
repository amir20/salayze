import Salayzer.DBParser.DatabaseInfo;
import Salayzer.JavaParser.ParseFile;
import Salayzer.SQLParser.SQLError;
import Salayzer.SQLParser.SQLStatement;
import Zql.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: amirraminfar2
 * Date: Apr 18, 2007
 * Time: 2:54:54 PM
 */
public class Salayze {


    public static void salayze(DatabaseInfo db_info, String file) {
        try {
            ParseFile pf = new ParseFile(new File(file));
            System.out.print("- Generating all possible SQL statements...");
            List<String> list = pf.getPossibleSQLStrings();
            System.out.println("done.");
            System.out.println("- Found a total of " + list.size() + " possible SQL statements.");
            System.out.println();
            int i = 0;
            for (String s : list) {
                System.out.println((++i) + ": " + s.replaceAll(SQLStatement.int_type, "").replaceAll(SQLStatement.string_type, ""));
                try {
                    SQLStatement parser = new SQLStatement(s);
                    parser.setDb_info(db_info);
                    parser.validateAll();
                    System.out.println("No errors found");
                } catch (SQLError sqlError) {
                    System.out.println(sqlError.getMessage());
                } catch (ParseException e) {
                    System.out.println("This is not a valid SQL statement");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot locate " + file + " on disk.");
        }
    }

    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                Map<String, String> db_info = parseDBInf(args[0]);
                salayze(new DatabaseInfo(db_info.get("host"), db_info.get("user"), db_info.get("pass"), db_info.get("database")), args[1]);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println(usage());
        }
    }

    public static Map<String, String> parseDBInf(String string) {
        Map<String, String> info = new Hashtable<String, String>();

        String[] split = string.split("@");

        String[] user_pass = split[0].split(":");
        info.put("user", user_pass[0]);
        info.put("pass", user_pass[1]);

        String[] host_db = split[1].split("/");
        info.put("host", host_db[0]);
        info.put("database", host_db[1]);

        return info;
    }

    public static String usage() {
        return "Salayzer usage: \n" +
                "                ./Salayzer <user>:<password>@<host>/<database> <filename>\n\n" +
                "         example: \n" +
                "                ./Salayzer db_user:secret@localhost/analyzer myFile.java\n\n" +
                "         parameters:\n" +
                "                 <filename>    --  File to parse\n" +
                "                 <user>        --  Database user for logging in\n" +
                "                 <password>    --  Database password for logging\n" +
                "                 <host>        --  Host url for databse [default: localhost]\n" +
                "                 <database>    --  Database name to use\n";
    }
}
