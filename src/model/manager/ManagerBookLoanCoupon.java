package model.manager;

import model.objects.BookLoanCoupon;

import java.util.List;

public class ManagerBookLoanCoupon {
    private List listBookLoanCoupon;

    public void addBook(BookLoanCoupon BookLoanCoupon){
    }
    public void removeBook(BookLoanCoupon BookLoanCoupon){

    }
    public void searchBook(String idBook){

    }
    public void printListBook(){
        for (int i = 0; i < listBookLoanCoupon.size(); i++) {
            System.out.println(listBookLoanCoupon.toString());
        }
    }
}
