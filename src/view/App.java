package view;

import model.hashtables.HashTable;
import model.manager.ManagerBook;
import model.objects.Book;

import javax.swing.*;
import java.util.List;

public class App {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        JTabbedPane m = new JTabbedPane();
//        BookView2 bookView2 = new BookView2();
//        BookBrrower bookBrrower = new BookBrrower();
        JFrame j1 = new JFrame();
        JFrame j2 = new JFrame();

        m.add(j1);
        m.add(j2);

//        m.add(bookView2);
//        m.add(bookBrrower);
        m.setVisible(true);
    }

    public static void print(List<Book> list) {
        for (Book temp : list) {
            System.out.println(temp);
        }
    }
}