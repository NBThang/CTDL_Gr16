package view;

import model.objects.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

class BookView extends JFrame {
    private ArrayList<Book> books;
    private JButton addBookBtn;
    private JButton deleteBookBtn;
    private JScrollPane jScrollPaneBookTable;
    private JTable bookTable;

    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel categoryLabel;
    private JLabel authorLabel;

    private JTextField idField;
    private JTextField nameField;
    private JTextField categoryField;
    private JTextField authorField;

    private String[] columns = new String[] {"ID", "Title", "Category", "Authors"};

    private Object data = new Object[][] {};

    public BookView() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Khoi tao cac phim chuc nang
        addBookBtn = new JButton("Add");
        deleteBookBtn = new JButton("Delete");
        // Khoi tao bang sach
        jScrollPaneBookTable = new JScrollPane();
        bookTable = new JTable();

        // Khoi tao cac label
        idLabel = new JLabel("ID");
        nameLabel = new JLabel("Title");
        categoryLabel = new JLabel("Category");
        authorLabel = new JLabel("Author");

        // Khoi tao cac truong nhap du lieu cho book
        idField = new JTextField(6);
        idField.setEditable(false);
        nameField = new JTextField(15);
        categoryField = new JTextField(10);
        authorField = new JTextField(15);

        // Cai dat cac cot va dât cho bang book
        bookTable.setModel(new DefaultTableModel((Object[][]) data, columns));
        jScrollPaneBookTable.setViewportView(bookTable);
        jScrollPaneBookTable.setPreferredSize(new Dimension(480, 300));

        // tao spring layout
        SpringLayout layout = new SpringLayout();
        // tao doi tuong panel de chua thanh phan man hinh quan ly
        JPanel panel = new JPanel(new BorderLayout());
        panel.setSize(800, 420);
        panel.setLayout(layout);
        panel.add(jScrollPaneBookTable);

        panel.add(addBookBtn);
        panel.add(deleteBookBtn);

        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(categoryLabel);
        panel.add(authorLabel);

        panel.add(idField);
        panel.add(nameField);
        panel.add(categoryField);
        panel.add(authorField);

        // Đặt vị trí các thành phần trên giao diện
        layout.putConstraint(SpringLayout.WEST, jScrollPaneBookTable, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneBookTable, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addBookBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addBookBtn, 10, SpringLayout.SOUTH, jScrollPaneBookTable);

        layout.putConstraint(SpringLayout.WEST, deleteBookBtn, 10, SpringLayout.EAST, addBookBtn);
        layout.putConstraint(SpringLayout.NORTH, deleteBookBtn, 10, SpringLayout.SOUTH, jScrollPaneBookTable);

        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.SOUTH, addBookBtn);

        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 10, SpringLayout.SOUTH, idLabel);

        layout.putConstraint(SpringLayout.WEST, categoryLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, categoryLabel, 10, SpringLayout.SOUTH, nameLabel);

        layout.putConstraint(SpringLayout.WEST, authorLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, authorLabel, 10, SpringLayout.SOUTH, categoryLabel);

        layout.putConstraint(SpringLayout.WEST, idField, 10, SpringLayout.EAST, idLabel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.SOUTH, addBookBtn);

        layout.putConstraint(SpringLayout.WEST, nameField, 10, SpringLayout.EAST, nameLabel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 10, SpringLayout.SOUTH, idField);

        layout.putConstraint(SpringLayout.WEST, categoryField, 10, SpringLayout.EAST, categoryLabel);
        layout.putConstraint(SpringLayout.NORTH, categoryField, 10, SpringLayout.SOUTH, nameField);

        layout.putConstraint(SpringLayout.WEST, authorField, 10, SpringLayout.EAST, authorLabel);
        layout.putConstraint(SpringLayout.NORTH, authorField, 10, SpringLayout.SOUTH, categoryField);

        this.add(panel);
        this.pack();
        this.setTitle("Library");
        this.setSize(800, 420);

        deleteBookBtn.setEnabled(false);

        addBookBtn.setEnabled(true);

    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void showListBook(ArrayList<Book> list) {
        int size = list.size();
        // với bảng studentTable có 5 cột,
        // khởi tạo mảng 2 chiều students, trong đó:
        // số hàng: là kích thước của list student
        // số cột: là 5
        Object[][] books = new Object[size][5];

        for (int i = 0; i < size; i++) {
            books[i][0] = list.get(i).getIdBook();
            books[i][1] = list.get(i).getNameBook();
            books[i][2] = list.get(i).getCategory();
            books[i][3] = list.get(i).getAuthor();
        }
        bookTable.setModel(new DefaultTableModel(books, columns));
    }
    public static void main (String[]args){
        SwingUtilities.invokeLater(() -> new BookView());
    }
}

