package objects;

import java.util.Date;

public class BookLoanCoupon {
    private String idBorrower;
    private String idBook;
    private Date borrowedDay;
    private Date payDay;

    public BookLoanCoupon(String idBorrower, String idBook, Date borrowedDay, Date payDay) {
        this.idBorrower = idBorrower;
        this.idBook = idBook;
        this.borrowedDay = borrowedDay;
        this.payDay = payDay;
    }

    public String getIdBorrower() {
        return idBorrower;
    }

    public void setIdBorrower(String idBorrower) {
        this.idBorrower = idBorrower;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public Date getBorrowedDay() {
        return borrowedDay;
    }

    public void setBorrowedDay(Date borrowedDay) {
        this.borrowedDay = borrowedDay;
    }

    public Date getPayDay() {
        return payDay;
    }

    public void setPayDay(Date payDay) {
        this.payDay = payDay;
    }

    @Override
    public String toString() {
        return "BookLoanCoupon{" +
                "idBorrower='" + idBorrower + '\'' +
                ", idBook='" + idBook + '\'' +
                ", borrowedDay=" + borrowedDay +
                ", payDay=" + payDay +
                '}';
    }
}
