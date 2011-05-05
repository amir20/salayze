import Salayzer.DBParser.ColumnInfo;
import Salayzer.DBParser.DatabaseInfo;
import Salayzer.DBParser.Info;
import junit.framework.TestCase;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: amirraminfar2
 * Date: Apr 11, 2007
 * Time: 10:41:43 PM
 */
public class DatabaseTest extends TestCase {
    DatabaseInfo databaseInfo;

    protected void setUp() throws Exception {
        databaseInfo = new DatabaseInfo("localhost", "cs342", "pass", "cs342");
    }

    public void test1() {
        Collection<ColumnInfo> m = databaseInfo.getDatabaseInfo().values();
        assertNotNull(m);
        assertTrue(m.size() > 0);
        for (ColumnInfo info : m) {
            System.out.println(info);
        }
    }

    public void test2() {
        ColumnInfo small = null;
        Collection<ColumnInfo> m = databaseInfo.getDatabaseInfo().values();
        for (ColumnInfo info : m) {
            if (info.getType() == Info.var_type.STRING && info.getLength() < 15) {
                small = info;
                break;
            }
        }


        assertNotNull(small);
    }
}
