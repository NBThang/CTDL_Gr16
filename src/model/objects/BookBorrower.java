package model.objects;

import java.util.Date;

public class BookBorrower {
    private String idBookBorrower;
    private String nameBorrower;
    private Date date;
    private String address;
    private String phone;



    public BookBorrower(String idBookBorrower, String nameBorrower, Date date, String address, String phone) {
        this.idBookBorrower = idBookBorrower;
        this.nameBorrower = nameBorrower;
        this.date = date;
        this.address = address;
        this.phone = phone;
    }

    public String getIdBookBorrower() {
        return idBookBorrower;
    }

    public void setIdBookBorrower(String idBookBorrower) {
        this.idBookBorrower = idBookBorrower;
    }

    public String getNameBorrower() {
        return nameBorrower;
    }

    public void setNameBorrower(String nameBorrower) {
        this.nameBorrower = nameBorrower;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BookBorrower{" +
                "idBookBorrower='" + idBookBorrower + '\'' +
                ", nameBorrower='" + nameBorrower + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
