package view2;

import java.beans.Statement;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Name
 */
public class RegisterView extends javax.swing.JPanel {

    /**
     * Creates new form LoginView2
     */
    public RegisterView() {
        initComponents();
    }

//    "com.microsoft.sqlserver.jdbc.SQLSeverDriver"
    String driver = "com.microsoft.sqlserver.jdbc.SQLSeverDriver";
    String url = "jdbc:mySQL://localhost:3306/dangnhap";
    String user = "root";
    String password = "";
    Statement st;
    ResultSet rs;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        txtgmail = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        txtconfig = new javax.swing.JPasswordField();
        btnlogin = new javax.swing.JButton();
        btndk = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thêm Tài Khoản");

        jLabel2.setText("UserName");

        jLabel3.setText("Email");

        jLabel4.setText("Password");

        jLabel5.setText("Config Password");

        btnlogin.setText("Login");

        btndk.setText("Đăng kí");
        btndk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addGap(44, 44, 44)
                                                        .addComponent(btnlogin)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btndk))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addGap(15, 15, 15)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(63, 63, 63)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(txtuser)
                                                                .addComponent(txtgmail)
                                                                .addComponent(txtpass)
                                                                .addComponent(txtconfig, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(142, 142, 142)
                                                .addComponent(jLabel1)))
                                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtgmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtconfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnlogin)
                                        .addComponent(btndk))
                                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void btndkActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int dk = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng ký", "Confirm", JOptionPane.YES_NO_OPTION);
        if (dk != JOptionPane.YES_OPTION) {
            return;
        }
        try{
//            Class.forName(driver);
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection(url, user, password);
            if (!txtpass.getText().equals(txtconfig.getText())) {
                JOptionPane.showMessageDialog(this, "Đăng kí thất bại");
            } else {
                String sql = "insert into ACCOUNT value (?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, txtuser.getText());
                ps.setString(2, txtgmail.getText());
                ps.setString(3, txtpass.getText());
                ps.setString(4, txtconfig.getText());

                int n = ps.executeUpdate();
                if (txtuser.getText().equals("")| txtgmail.getText().equals("")| txtpass.getText().equals("")| txtconfig.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Không để thông tin trống");
                } else if (n!= 0) {
                    JOptionPane.showMessageDialog(this, "Đăng kí thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Đăng kí thất bại");
                }
            }

        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Đăng kí thất bại");
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btndk;
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtconfig;
    private javax.swing.JTextField txtgmail;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration

    public static void run() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Test LoginView2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RegisterView loginView2 = new RegisterView();
        frame.getContentPane().add(loginView2);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

