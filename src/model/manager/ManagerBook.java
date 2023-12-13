package model.manager;


import model.hashtables.Entry;
import model.hashtables.HashTable;
import model.objects.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ManagerBook {
    private HashTable<String, Book> hashTable;
    private List<Book> listBook;
    public ManagerBook() {
        this.hashTable = new HashTable<>();
        listBook = new ArrayList<>();
    }

    public void addBook(Book book){
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
        }
    }
    public void removeBook(Book book){
        int sizeHash = hashTable.size();
        hashTable.remove(book.getIdBook());

        if (sizeHash == hashTable.size()) {
            System.out.println("Don't find your book");
        }

        listBook.remove(book);
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


    public static void main(String[] args) {

    }
}
