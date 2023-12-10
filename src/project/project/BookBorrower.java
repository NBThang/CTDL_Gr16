package project;

public class BookBorrower {
    private String idBookBorrower;
    private String nameBorrower;
    private String address;
    private String email;
    private String phone;

    public BookBorrower(String idBookBorrower, String nameBorrower, String address, String email, String phone) {
        this.idBookBorrower = idBookBorrower;
        this.nameBorrower = nameBorrower;
        this.address = address;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "BookBorrower{" +
                "idBookBorrower='" + idBookBorrower + '\'' +
                ", nameBorrower='" + nameBorrower + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
