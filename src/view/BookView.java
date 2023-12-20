package view;

import model.manager.ManagerBook;
import model.objects.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.beans.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Name
 */
public class BookView extends javax.swing.JFrame {

    private ManagerBook manegerBook;
    BookBrrower bookBrrower = new BookBrrower();
    DefaultTableModel model;

    private String driver = "com.microsoft.sqlserver.jdbc.SQLSeverDriver";
    private String url = "jdbc:mySQL://localhost:3306/bookdata";
    private String user = "root";
    private String password = "";
    private Statement st;
    private ResultSet rs;

    /**
     * Creates new form BookView
     */
    public BookView() {
        initComponents();
        this.manegerBook = new ManagerBook();
        model = (DefaultTableModel) jtable.getModel();
        getDataToTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        this.setTitle("BookView");

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txttitle = new javax.swing.JTextField();
        txtauthor = new javax.swing.JTextField();
        txtcategory = new javax.swing.JTextField();
        txtsearch = new javax.swing.JTextField();
        jcbsearch = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        btnadd = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();
        btnsdm = new javax.swing.JButton();
        btnmuon = new javax.swing.JButton();
        btnrenew = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID");

        jLabel2.setText("Tên Sách");

        jLabel3.setText("Tác Giả");

        jLabel4.setText("Thể Loại");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tìm Kiếm");

        jLabel7.setText("Từ Khóa");

        jcbsearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Tên Sách", "Tác Giả", "Thể Loại" }));
        jcbsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbsearchActionPerformed(evt);
            }
        });

        jtable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "Tên Sách", "Tác Giả", "Thể Loại"
                }
        ));
        jScrollPane1.setViewportView(jtable);

        btnadd.setText("Thêm");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        btnsdm.setText("Sách đã mượn");
        btnsdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsdmActionPerformed(evt);
            }
        });

        btnmuon.setText("Mượn");
        btnmuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmuonActionPerformed(evt);
            }
        });

        btnrenew.setText("Làm Mới");
        btnrenew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrenewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(btnadd)))
                                                .addGap(55, 55, 55)
                                                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jcbsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnsearch)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnrenew)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(125, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(txtauthor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txttitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(36, 36, 36)
                                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnmuon)
                                                                .addGap(29, 29, 29)
                                                                .addComponent(btnsdm)))
                                                .addGap(59, 59, 59)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(txttitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(37, 37, 37)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(36, 36, 36)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(45, 45, 45)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnadd)
                                                        .addComponent(btnsdm)
                                                        .addComponent(btnmuon))
                                                .addGap(44, 44, 44)
                                                .addComponent(jLabel6)
                                                .addGap(34, 34, 34)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jcbsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnsearch)
                                        .addComponent(btnrenew))
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();

    }// </editor-fold>
    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String id = txtid.getText();
        String title = txttitle.getText();
        String author = txtauthor.getText();
        String catagory = txtcategory.getText();

        if (id.equals("") || title.equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập thông tin");
            return;
        }

        Book book = new Book(id, title, author, catagory);

        int sizeBefor = manegerBook.size();
        manegerBook.addBook(book);
        int sizeAfter = manegerBook.size();

        if (sizeBefor != sizeAfter) {
            addToTable(book);
        }else {
            JOptionPane.showMessageDialog(this, "Error");
        }
    }

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (txtsearch.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập thông tin");
            return;
        }

        if (jcbsearch.getSelectedItem().equals("ID")) {
            List<Book> list = new ArrayList<>();
            Book book = manegerBook.searchBookById(txtsearch.getText().toLowerCase());

            if(book == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sách bạn yêu cầu");
                return;
            } else {
                model.setRowCount(0);
                list.add(book);
                addToTable(list);
            }

        } else if (jcbsearch.getSelectedItem().equals("Tên Sách")) {
            List<Book> list = manegerBook.searchBookByName(txtsearch.getText().toLowerCase());

            if (list.size() == 0) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sách bạn yêu cầu");
                return;
            } else {
                model.setRowCount(0);
                addToTable(list);
            }
        } else if (jcbsearch.getSelectedItem().equals("Tác Giả")) {
            List<Book> list = manegerBook.searchBookByAuthor(txtsearch.getText().toLowerCase());

            if (list.size() == 0) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sách bạn yêu cầu");
                return;
            } else {
                model.setRowCount(0);
                addToTable(list);
            }
        } else if (jcbsearch.getSelectedItem().equals("Thể Loại")) {
            List<Book> list = manegerBook.searchBookByCategory(txtsearch.getText().toLowerCase());

            if (list.size() == 0) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sách bạn yêu cầu");
                return;
            } else {
                model.setRowCount(0);
                addToTable(list);
            }
        }
    }

    private void btnsdmActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        bookBrrower.setVisible(true);
    }

    List<String> listIDBrrower = new ArrayList<>();
    private void btnmuonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int row = jtable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sách");
            return;
        }

        String id = jtable.getValueAt(row, 0).toString();
        String tensach = jtable.getValueAt(row, 1).toString();
        String tacgia = jtable.getValueAt(row, 2).toString();
        String theloai = jtable.getValueAt(row, 3).toString();

        if (listIDBrrower.contains(id)) {
            JOptionPane.showMessageDialog(this, "Bạn đã mượn sách này rồi");
        } else {
            listIDBrrower.add(id);
            Book b = new Book(id, tensach, tacgia, theloai);
            bookBrrower.addBook(b);
            JOptionPane.showMessageDialog(this, "Mượn hành công");
        }
    }

    private void btnrenewActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        model.setRowCount(0);
        getDataToTable();
    }


    private void jcbsearchActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addToTable(Book b) {
//        Book b = manegerBook.getByIndex(manegerBook.size() - 1);

        model.addRow(new Object[] {
                b.getIdBook().trim(), b.getNameBook().trim(), b.getCategory().trim(), b.getAuthor().trim()
        });
    }

    private void addToTable(List<Book> list) {
        for (int i = 0; i < list.size(); i++) {
            Book b = list.get(i);
            model.addRow(new Object[] {
                    b.getIdBook(), b.getNameBook(), b.getAuthor(), b.getCategory()
            });
        }
    }

    public void getDataToTable(){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "select * from book";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            ResultSetMetaData stData = rs.getMetaData();

            int q = stData.getColumnCount();

            DefaultTableModel recordTable = (DefaultTableModel) jtable.getModel();
            recordTable.setRowCount(0);

            while (rs.next()) {
                Vector columdata = new Vector<>();

                for (int i = 1; i <= q; i++) {
                    columdata.add(rs.getString("id"));
                    columdata.add(rs.getString("tensach"));
                    columdata.add(rs.getString("tacgia"));
                    columdata.add(rs.getString("theloai"));
                }

                recordTable.addRow(columdata);
            }
        } catch (Exception e) {

        }
    }



    /*
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnsdm;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnmuon;
    private javax.swing.JButton btnrenew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbsearch;
    private javax.swing.JTable jtable;
    private javax.swing.JTextField txtauthor;
    private javax.swing.JTextField txtcategory;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txttitle;
    // End of variables declaration

}

