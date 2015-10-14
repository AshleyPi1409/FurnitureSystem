/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.Employee;
import entities.Role;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.EmployeeEntityManager;
import models.RoleEntityManager;

/**
 *
 * @author ADMIN
 */
public final class AccountFormDB extends javax.swing.JInternalFrame {

    /**
     * Creates new form AccountFormDB
     *
     *
     *
     */
    static AccountFormDB instance = null;
    DefaultTableModel dtm;
    DefaultComboBoxModel<String> dlm = new DefaultComboBoxModel<>();
    RoleEntityManager roleModel = new RoleEntityManager();
    EmployeeEntityManager accModel = new EmployeeEntityManager();

    public AccountFormDB() {
        initComponents();
        setIcon();
        createTable();
        loadAccountListTable(null);
        loadRoleList();
        centerTextCell(tblAccount);
        //setFormEditable(false);
    }

    void setFormEditable(boolean editable) {
//        txtId.setEditable(editable);
        txtName.setEnabled(editable);
        txtPassword.setEnabled(editable);
        cbbRole.setEnabled(editable);

        cbbRole.setEnabled(editable);

    }

    public void setIcon() {
        this.setFrameIcon(new ImageIcon(getClass().getResource("/img/Coffee-break-icon.png")));
    }

    void centerTextCell(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    /**
     * singleton Account Form
     *
     * @return
     */
    public static AccountFormDB getIns() {
        if (instance == null) {
            instance = new AccountFormDB();
        }
        return instance;

    }

    /**
     *
     * create Table to show Account list set table model
     *
     */
    void createTable() {

        dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
        };

        dtm.addColumn("ID");
        dtm.addColumn("Username");
        dtm.addColumn("Password");
        dtm.addColumn("Role");

        tblAccount.setModel(dtm);
    }

    /**
     *
     * Fill data to table list of account with button column and their action
     *
     */
    void loadAccountListTable(List<Account> l) {
        createTable();
        if (l != null) {
            for (Account acc : l) {
                dtm.addRow(new Object[]{acc.getId(), acc.getUsername(), acc.getPassword(), acc.getRole().getName()});

            }
        } else {
            for (Account acc : accModel.getAll()) {
                dtm.addRow(new Object[]{acc.getId(), acc.getUsername(), acc.getPassword(), acc.getRole().getName()});

            }
        }
        tblAccount.setModel(dtm);

        /*Action edit = new AbstractAction() {

         @Override
         public void actionPerformed(ActionEvent e) {
         setFormEditable(true);
         editMode = EditMode.editModeEdit;
         }
         };

         Action delete = new AbstractAction() {

         @Override
         public void actionPerformed(ActionEvent e) {
         Account a = accModel.find(Integer.valueOf(txtId.getText()));
         if (a != null) {
         accModel.delete(a);
         JOptionPane.showMessageDialog(rootPane, "Deleted");
         loadAccountListTable(null);
         }

         }

         };
         new ButtonColumn(tblAccount, edit, 4);
         new ButtonColumn(tblAccount, delete, 5);*/
    }

    /**
     * Fill data to combo box of role
     */
    void loadRoleList() {

        for (Role r : roleModel.getAll()) {
            dlm.addElement(r.getName());
        }
        cbbRole.setModel(dlm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlInput = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        cbbRole = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btncreate = new javax.swing.JButton();
        pnlOutput = new javax.swing.JPanel();
        scrUser = new javax.swing.JScrollPane();
        tblAccount = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        setTitle("Account Manager");
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setMinimumSize(new java.awt.Dimension(0, 0));
        setNormalBounds(new java.awt.Rectangle(0, 0, 126, 0));
        setPreferredSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlInput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "User Control"));
        pnlInput.setMinimumSize(new java.awt.Dimension(420, 479));
        pnlInput.setPreferredSize(new java.awt.Dimension(420, 479));
        pnlInput.setLayout(new java.awt.GridBagLayout());

        lblId.setText("Role:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        pnlInput.add(lblId, gridBagConstraints);

        lblName.setText("Name: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        pnlInput.add(lblName, gridBagConstraints);

        lblPassword.setText("Password: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        pnlInput.add(lblPassword, gridBagConstraints);

        txtName.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlInput.add(txtName, gridBagConstraints);

        txtPassword.setMinimumSize(new java.awt.Dimension(6, 25));
        txtPassword.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlInput.add(txtPassword, gridBagConstraints);

        cbbRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbRoleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 0);
        pnlInput.add(cbbRole, gridBagConstraints);

        jLabel1.setText("Id: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        pnlInput.add(jLabel1, gridBagConstraints);

        txtId.setEditable(false);
        txtId.setEnabled(false);
        txtId.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        pnlInput.add(txtId, gridBagConstraints);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sua.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlInput.add(btnEdit, gridBagConstraints);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/xoa.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlInput.add(btnDelete, gridBagConstraints);

        btncreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/them.png"))); // NOI18N
        btncreate.setToolTipText("add");
        btncreate.setPreferredSize(new java.awt.Dimension(75, 25));
        btncreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        pnlInput.add(btncreate, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 3, 5, 3);
        getContentPane().add(pnlInput, gridBagConstraints);

        pnlOutput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "User Data"));
        pnlOutput.setMinimumSize(new java.awt.Dimension(462, 477));
        pnlOutput.setPreferredSize(new java.awt.Dimension(462, 477));
        pnlOutput.setLayout(new java.awt.GridBagLayout());

        scrUser.setPreferredSize(new java.awt.Dimension(420, 405));

        tblAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAccount.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblAccount.setPreferredSize(new java.awt.Dimension(1358, 627));
        tblAccount.getTableHeader().setReorderingAllowed(false);
        tblAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAccountMouseClicked(evt);
            }
        });
        scrUser.setViewportView(tblAccount);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlOutput.add(scrUser, gridBagConstraints);

        lblSearch.setText("Search: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlOutput.add(lblSearch, gridBagConstraints);

        txtSearch.setText("type a name...");
        txtSearch.setPreferredSize(new java.awt.Dimension(200, 25));
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 120);
        pnlOutput.add(txtSearch, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(pnlOutput, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Button create action: set visible for all JTextField
     *
     *
     */
    private void btncreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreateActionPerformed
        // TODO add your handling code here:
        //  setFormEditable(true);

        String roleName = cbbRole.getSelectedItem().toString();
        String pass = new String(txtPassword.getPassword());

        if (roleName == null || pass == null) {
            JOptionPane.showConfirmDialog(rootPane, "Xin điền đủ thông tin!");
        }
        Account a = null;
        for (Role role : roleModel.getAll()) {
            if (role.getName().equals(roleName)) {
                a = new Account(role, txtName.getText(), pass, true);
            }
        }

        if (accModel.addNew(a)) {
            JOptionPane.showMessageDialog(rootPane, "Thêm Account thành công!");
            loadAccountListTable(accModel.getAll());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Đã tồn tại account này.");

        }

    }//GEN-LAST:event_btncreateActionPerformed

    /**
     * Table action: when click on a row, set all text for JTextField and
     * JCombobox ====not done
     *
     */
    private void tblAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAccountMouseClicked
        // TODO add your handling code here:
        int selected = tblAccount.getSelectedRow();
        txtId.setText(dtm.getValueAt(selected, 0).toString());
        txtName.setText(dtm.getValueAt(selected, 1).toString());
        txtPassword.setText(dtm.getValueAt(selected, 2).toString());
        cbbRole.setSelectedItem(dtm.getValueAt(selected, 3).toString());


    }//GEN-LAST:event_tblAccountMouseClicked
    /**
     * clear place holder
     */
    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        // TODO add your handling code here:
        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        // TODO add your handling code here:
        List<Account> l = new ArrayList<>();
        for (Account a : accModel.getAll()) {
            if (a.getUsername().contains(txtSearch.getText())) {
                l.add(a);
            }
        }
        loadAccountListTable(l);
    }//GEN-LAST:event_txtSearchKeyTyped

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String roleName = cbbRole.getSelectedItem().toString();
        String pass = new String(txtPassword.getPassword());

        if (roleName == null || pass == null) {
            JOptionPane.showConfirmDialog(rootPane, "Xin điền đủ thông tin!");
        }

        Account a = new Account();
        a.setId(Integer.parseInt(txtId.getText()));
        a.setUsername(txtName.getText());
        a.setPassword(pass);
        a.setIsActive(true);
        for (Role role : roleModel.getAll()) {
            if (role.getName().equalsIgnoreCase(roleName)) {
                a.setRole(role);
            }
        }
        if (accModel.edit(a)) {
            JOptionPane.showMessageDialog(rootPane, "Sửa Account thành công!");
            loadAccountListTable(accModel.getAll());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Failed");

        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void cbbRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbRoleActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String roleName = cbbRole.getSelectedItem().toString();
        String pass = new String(txtPassword.getPassword());

        if (roleName == null || pass == null) {
            JOptionPane.showConfirmDialog(rootPane, "Xin điền đủ thông tin!");
        }

        Account a = new Account();
        a.setId(Integer.parseInt(txtId.getText()));
        a.setUsername(txtName.getText());
        a.setPassword(pass);
        a.setIsActive(true);
        for (Role role : roleModel.getAll()) {
            if (role.getName().equalsIgnoreCase(roleName)) {
                a.setRole(role);
            }
        }
        accModel.delete(a);
        JOptionPane.showMessageDialog(rootPane, "Xóa account thành công");
        loadAccountListTable(accModel.getAll());
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btncreate;
    private javax.swing.JComboBox cbbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JPanel pnlOutput;
    private javax.swing.JScrollPane scrUser;
    private javax.swing.JTable tblAccount;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
