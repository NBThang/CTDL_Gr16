package model.manager;


import model.hashtables.Entry;
import model.hashtables.HashTable;
import model.objects.Book;
import view.BookView2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import java.beans.Statement;

import java.util.*;

public class ManagerBook {
    private HashTable<String, Book> hashTable;
    private List<Book> listBook;
    public ManagerBook() {
        this.hashTable = new HashTable<>();
        listBook = new ArrayList<>();
//        getDataToTable();
    }

    private String driver = "com.microsoft.sqlserver.jdbc.SQLSeverDriver";
    private String url = "jdbc:mySQL://localhost:3306/bookdata";
    private String user = "root";
    private String password = "";
    private Statement st;
    private ResultSet rs;

    public void addBook(Book book) {
        hashTable.put(book.getIdBook(), book);

        boolean alreadyExists = false;

        for (Book existingBook : listBook) {
            if (existingBook.getIdBook().equals(book.getIdBook())) {
                alreadyExists = true;
                break;
            }
        }

        if (!alreadyExists) {
            listBook.add(book);
            this.addSQL(book);
        }
    }
    public void removeBook(Book book){
        int sizeHash = hashTable.size();
        hashTable.remove(book.getIdBook());

        if (sizeHash == hashTable.size()) {
            System.out.println("Don't find your book");
        }

        listBook.remove(book);

        this.remoteSQL(book);
    }
    public Book searchBookById(String idBook){
        return hashTable.get(idBook);
    }

    public List<Book> searchBookByAuthor(String authorName) {
        List<Book> booksByAuthor = new ArrayList<>();

        for (LinkedList<Entry<String, Book>> bucket : hashTable.getBuckets()) {
            for (Entry<String, Book> entry : bucket) {
                Book book = entry.getValue();
                if (book.getAuthor().equalsIgnoreCase(authorName)) {
                    booksByAuthor.add(book);
                }
            }
        }

        return booksByAuthor;
    }

    public List<Book> searchBookByCategory(String category) {
        List<Book> booksByTitle = new ArrayList<>();

        for (LinkedList<Entry<String, Book>> bucket : hashTable.getBuckets()) {
            for (Entry<String, Book> entry : bucket) {
                Book book = entry.getValue();
                if (book.getCategory().equalsIgnoreCase(category)) {
                    booksByTitle.add(book);
                }
            }
        }

        return booksByTitle;
    }

    public List<Book> searchBookByName(String bookName) {
        List<Book> booksByName = new ArrayList<>();

        for (LinkedList<Entry<String, Book>> bucket : hashTable.getBuckets()) {
            for (Entry<String, Book> entry : bucket) {
                Book book = entry.getValue();
                if (book.getNameBook().equalsIgnoreCase(bookName)) {
                    booksByName.add(book);
                }
            }
        }

        return booksByName;
    }

    public List<Book> sortBookByName() {
        List<Book> bookList = hashTable.getAllValues();

        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.getNameBook().compareToIgnoreCase(book2.getNameBook());
            }
        });

        return bookList;
    }

    public void printListBook(){
        List<Book> bookList = hashTable.getAllValues();

        if (bookList.isEmpty()) {
            System.out.println("No books in the list");
        } else {
            System.out.println("List of Books:");
            for (Book book : bookList) {
                System.out.println(book.toString());
            }
        }
    }

    public List<Book> getAllBooks() {
        return hashTable.getAllValues();
    }

    public List<String> getAllCategories() {
        List<Book> bookList = hashTable.getAllValues();
        Set<String> categoriesSet = new HashSet<>();

        for (Book book : bookList) {
            categoriesSet.add(book.getCategory());
        }

        return new ArrayList<>(categoriesSet);
    }

    public Book getByIndex(int i) {
        return listBook.get(i);
    }

    public int size() {
        return hashTable.size();
    }

    private void addSQL(Book b) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection(url, user, password);

            java.sql.Statement st = con.createStatement();
            String sql = "INSERT INTO BOOK (id, tensach, tacgia, theloai)" +
                    " VALUES("+b.getIdBook()+" , "+b.getNameBook()+" , "+b.getAuthor()+" , "+b.getCategory()+")";

            PreparedStatement ps = con.prepareStatement(sql);
            int n = ps.executeUpdate();

            BookView2 bv = new BookView2();

            if (n != 0) {
                int resuil = st.executeUpdate(sql);
            } else {
                JOptionPane.showMessageDialog(bv, "Thêm sách thất bại");
            }

        } catch (Exception e){

        }
    }

//    public void getDataToTable(){
//        try {
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            Connection con = DriverManager.getConnection(url, user, password);
//            String sql = "select * from book";
//            PreparedStatement pst = con.prepareStatement(sql);
//            ResultSet rs = pst.executeQuery();
//
//            ResultSetMetaData stData = rs.getMetaData();
//
//            int q = stData.getColumnCount();
//
//            DefaultTableModel recordTable = (DefaultTableModel) bookView2.jtable.getModel();
//            recordTable.setRowCount(0);
//
//            while (rs.next()) {
//
//                for (int i = 1; i <= q; i++) {
//                    String id = rs.getString("id");
//                    String tensach = rs.getString("tensach");
//                    String tacgia = rs.getString("tacgia");
//                    String theloai = rs.getString("theloai");
//
//                    Book b = new Book(id, tensach, tacgia, theloai);
//
//                    listBook.add(b);
//                    hashTable.put(b.getIdBook(), b);
//                }
//            }
//        } catch (Exception e) {
//
//        }
//    }

    private void remoteSQL(Book b) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection(url, user, password);

            java.sql.Statement st = con.createStatement();
            String sql = "INSERT INTO BOOK (id, tensach, tacgia, theloai)" +
                    " VALUES("+b.getIdBook()+" , "+b.getNameBook()+" , "+b.getAuthor()+" , "+b.getCategory()+")";

            int resuil = st.executeUpdate(sql);

        } catch (Exception e){

        }
    }

    public static void main(String[] args) {
        ManagerBook m = new ManagerBook();
        System.out.println(m.listBook.get(0).getIdBook());
    }
}
