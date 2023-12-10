package project;

import java.util.List;

public class ManagerBook {
    private List listBook;

    public void addBook(Book book){
    }
    public void removeBook(Book book){

    }
    public void searchBook(String idBook){

    }
    public void printListBook(){
        for (int i = 0; i < listBook.size(); i++) {
            System.out.println(listBook.toString());
        }
    }
}
