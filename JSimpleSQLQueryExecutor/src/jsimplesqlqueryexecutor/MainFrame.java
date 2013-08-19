package jsimplesqlqueryexecutor;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends javax.swing.JFrame {

    SQLExecutor ex = new SQLExecutor();
    ResultSetTableModel model;

    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        pnlControls = new javax.swing.JPanel();
        cbbDatabases = new javax.swing.JComboBox();
        lblGap = new javax.swing.JLabel();
        btnExec = new javax.swing.JButton();
        pnlStt = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlSplit = new javax.swing.JSplitPane();
        pnlQrEdtBound = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaQrEditor = new javax.swing.JTextArea();
        pnlResultTableBound = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbbDatabases.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlControls.add(cbbDatabases);

        lblGap.setText("                                                       ");
        pnlControls.add(lblGap);

        btnExec.setText("Execute");
        btnExec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecActionPerformed(evt);
            }
        });
        pnlControls.add(btnExec);

        getContentPane().add(pnlControls, java.awt.BorderLayout.PAGE_START);

        pnlStt.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setText("Status");
        pnlStt.add(jLabel1);

        getContentPane().add(pnlStt, java.awt.BorderLayout.PAGE_END);

        pnlSplit.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        pnlQrEdtBound.setLayout(new java.awt.BorderLayout());

        txaQrEditor.setColumns(20);
        txaQrEditor.setRows(5);
        jScrollPane1.setViewportView(txaQrEditor);

        pnlQrEdtBound.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlSplit.setTopComponent(pnlQrEdtBound);

        pnlResultTableBound.setLayout(new java.awt.BorderLayout());

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblResult);

        pnlResultTableBound.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pnlSplit.setRightComponent(pnlResultTableBound);

        getContentPane().add(pnlSplit, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecActionPerformed
        ResultSet rs = ex.executeQuerry(txaQrEditor.getText());
        model = new ResultSetTableModel(rs);
        this.tblResult.setModel(model);
    }//GEN-LAST:event_btnExecActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExec;
    private javax.swing.JComboBox cbbDatabases;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGap;
    private javax.swing.JPanel pnlControls;
    private javax.swing.JPanel pnlQrEdtBound;
    private javax.swing.JPanel pnlResultTableBound;
    private javax.swing.JSplitPane pnlSplit;
    private javax.swing.JPanel pnlStt;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextArea txaQrEditor;
    // End of variables declaration//GEN-END:variables
}
