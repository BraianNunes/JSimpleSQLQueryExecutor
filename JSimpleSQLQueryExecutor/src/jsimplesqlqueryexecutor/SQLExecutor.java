/* @author chad */
package jsimplesqlqueryexecutor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLExecutor {

    public ResultSet executeQuerry(String sql) {
        try {
            Connection cnn = ConnectionUtil.getConnection();
            Statement stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stm.executeQuery(sql);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return null;
    }
}
