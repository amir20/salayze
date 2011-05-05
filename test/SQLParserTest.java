import Salayzer.DBParser.DatabaseInfo;
import Salayzer.SQLParser.SQLError;
import Salayzer.SQLParser.SQLStatement;
import Zql.ParseException;
import junit.framework.TestCase;

/**
 * Created by IntelliJ IDEA.
 * User: amirraminfar2
 * Date: Apr 13, 2007
 * Time: 3:08:46 PM
 */


public class SQLParserTest extends TestCase {
    SQLStatement parser;

    public void setUp() {

    }

    public void testSelect() throws ParseException {
        String q = "SELECT new_type FROM test_table2 WHERE id=1 OR id=java_var_int_number OR id=java_var_int_mytext;";
        parser = new SQLStatement(q);
        parser.setDb_info(new DatabaseInfo("localhost", "cs342", "pass", "cs342"));


        try {
            parser.validateAll();
        } catch (SQLError sqlError) {
            System.out.println(sqlError);
        }


    }


}
