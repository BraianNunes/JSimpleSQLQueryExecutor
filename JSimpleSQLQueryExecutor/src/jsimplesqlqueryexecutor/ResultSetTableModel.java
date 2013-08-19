/* @author chad */
package jsimplesqlqueryexecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel {

    ResultSet rs;

    public ResultSetTableModel(ResultSet rs) {
        setResultSet(rs);
    }

    private void setResultSet(ResultSet rs) {
        this.rs = rs;
        fireTableDataChanged();
    }

    public ResultSet getResultSet() {
        return rs;
    }

    @Override
    public int getRowCount() {
        int count = 0;
        try {
            rs.last();
            count = rs.getRow();
            rs.beforeFirst();
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    @Override
    public int getColumnCount() {
        int count = 0;
        try {
            count = rs.getMetaData().getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            this.rs.absolute(rowIndex + 1);
            return this.rs.getObject(columnIndex + 1);
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        try {
            return this.rs.getMetaData().getColumnName(column + 1);
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        try {
            return Class.forName(this.rs.getMetaData().getColumnClassName(columnIndex + 1));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Object.class;
    }
    
}
