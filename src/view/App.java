package view;

import model.hashtables.HashTable;
import model.manager.ManagerBook;
import model.objects.Book;

import java.util.List;

public class App {
    public static void main(String[] args) {
////        Book b1 = new Book("1", "thang", 1, "tieu thuyet", "A", "da muon");
////        Book b2 = new Book("2", "tuan", 1, "tieu thuyet", "b", "da muon");
////        Book b3 = new Book("3", "tuan", 1, "tieu thuyet", "C", "da muon");
////        Book b4 = new Book("4", "lam", 1, "tieu thuyet", "A", "da muon");
//
//        ManagerBook managerBook = new ManagerBook();
//
////        managerBook.addBook(b1);
////        managerBook.addBook(b2);
////        managerBook.addBook(b3);
////        managerBook.addBook(b4);
//
//        List<Book> list = managerBook.searchBookByAuthor("A");
//        print(list);
    }

    public static void print(List<Book> list) {
        for (Book temp : list) {
            System.out.println(temp);
        }
    }
}