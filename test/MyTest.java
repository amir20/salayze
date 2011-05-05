import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by IntelliJ IDEA.
 * User: amirraminfar2
 * Date: Apr 16, 2007
 * Time: 1:33:23 AM
 */
public class MyTest {
    private int number;

    public MyTest() {
        String url = "jdbc:mysql://dummy:3306/";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, null, null);
            Statement stmt = null;
            stmt = conn.createStatement();
            int number = 0;
            String text;

            String q = "SELECT";
            if (1 == 1) {
                q += " bad_column";
            } else if (3 == 3) {
                q += " int_type, string_type";
            }

            q += " FROM";

            if (1 == 1) {
                q += " bad_table";
            } else {
                if (111 == 1) {
                    q += " test_table WHERE id=" + number;
                } else {
                    q += " test_table WHERE string_type=";

                    if (1 == 1) {
                        q += number;
                    } else if (22 == 22) {
                        q += text;
                    } else {
                        q += "1";
                    }
                }
            }


            stmt.executeQuery(q);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
