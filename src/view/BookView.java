package view;

import model.objects.Book;

import javax.swing.*;
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

    private String[] columns = new String[] {"ID", "Title", "Category", "Authors"};

    private Object data = new Object[][] {};

    public BookView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new BorderLayout());
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



        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> bookList = new JList<>(listModel);

        for (Book book : books) {
            listModel.addElement(book.toString());
        }

        JScrollPane scrollPane = new JScrollPane(bookList);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
    }
}
