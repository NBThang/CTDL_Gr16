package objects;

public class Book {
    private String idBook;
    private String nameBook;
    private int number;
    private String category;
    private String author;
    private String status;

    public Book(String idBook, String nameBook, int number, String category, String author, String status) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.number = number;
        this.category = category;
        this.author = author;
        this.status = status;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook='" + idBook + '\'' +
                ", nameBook='" + nameBook + '\'' +
                ", number=" + number +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
