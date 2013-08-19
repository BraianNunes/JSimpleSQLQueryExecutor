/* @author chad */
package jsimplesqlqueryexecutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:4444;databaseName=PlayersData", "sa", "Mainguyen");
    }
}
