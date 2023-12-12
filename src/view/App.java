package view;

import model.hashtables.HashTable;
import model.manager.ManagerBook;
import model.objects.Book;
import view2.LoginView2;

import java.util.List;

public class App {
    public static void main(String[] args) {
        LoginView2 lgv = new LoginView2();
        lgv.setVisible(true);
    }

    public static void print(List<Book> list) {
        for (Book temp : list) {
            System.out.println(temp);
        }
    }
}