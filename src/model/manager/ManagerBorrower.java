package model.manager;

import model.hashtables.Entry;
import model.hashtables.HashTable;
import model.objects.Book;
import model.objects.BookBorrower;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ManagerBorrower {
    private HashTable<String, BookBorrower> hash;

    public ManagerBorrower() {
        this.hash = new HashTable<>();
    }

    public void addBorrower(BookBorrower borrower){
        hash.put(borrower.getIdBookBorrower(), borrower);
    }

    public void removeBorrower(BookBorrower borrower){
        hash.remove(borrower.getIdBookBorrower());
    }
    public BookBorrower searchBorrowerById(String idBorrower){
        return hash.get(idBorrower);
    }

    public BookBorrower searchBorrowerByPhone(String phoneNumber) {
        for (LinkedList<Entry<String, BookBorrower>> bucket : hash.getBuckets()) {
            for (Entry<String, BookBorrower> entry : bucket) {
                BookBorrower borrower = entry.getValue();
                if (borrower.getPhone().equals(phoneNumber)) {
                    return borrower;
                }
            }
        }

        return null;
    }

    public List<BookBorrower> sortByName() {
        List<BookBorrower> borrowerList = hash.getAllValues();

        Collections.sort(borrowerList, new Comparator<BookBorrower>() {
            @Override
            public int compare(BookBorrower borrower1, BookBorrower borrower2) {
                return borrower1.getNameBorrower().compareToIgnoreCase(borrower2.getNameBorrower());
            }
        });

        return borrowerList;
    }

    public void printListBrrowerBook(){
        List<BookBorrower> bookList = hash.getAllValues();

        if (bookList.isEmpty()) {
            System.out.println("No bookBrrower in the list");
        } else {
            System.out.println("List of BookBrrower:");
            for (BookBorrower book : bookList) {
                System.out.println(book.toString());
            }
        }
    }

    public List<BookBorrower> getAllBorrowers() {
        return hash.getAllValues();
    }
}
