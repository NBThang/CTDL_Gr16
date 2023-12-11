package model.manager;

import model.objects.Book;
import model.objects.BookBorrower;

import java.util.List;

public class Statistical {
    private ManagerBook managerBook;
    private ManagerBorrower managerBorrower;

    public Statistical(ManagerBook managerBook, ManagerBorrower managerBorrower) {
        this.managerBook = managerBook;
        this.managerBorrower = managerBorrower;
    }

    public int getTotalBooks() {
        List<Book> bookList = managerBook.getAllBooks();
        return bookList.size();
    }

    public int getTotalBorrowers() {
        List<BookBorrower> borrowerList = managerBorrower.getAllBorrowers();
        return borrowerList.size();
    }

    public List<String> getAllCategories() {
        return managerBook.getAllCategories();
    }
}
