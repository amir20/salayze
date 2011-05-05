import Salayzer.JavaParser.ParseFile;
import junit.framework.TestCase;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: amirraminfar2
 * Date: Apr 14, 2007
 * Time: 11:27:42 PM
 */
public class JavaParserTest extends TestCase {
    public void setUp() {

    }

    public void testVariables() throws FileNotFoundException {
        ParseFile pf = new ParseFile("test/MyTest.java");
        List<String> list = pf.getPossibleSQLStrings();
        for (String sql : list) {
            System.out.println("sql = " + sql);
        }
    }

}
