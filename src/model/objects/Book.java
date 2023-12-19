package model.objects;

public class Book {
    private String idBook;
    private String nameBook;
    private String author;
    private String category;


    public Book(String idBook, String nameBook, String author, String category) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.author = author;
        this.category = category;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook='" + idBook + '\'' +
                ", nameBook='" + nameBook + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
