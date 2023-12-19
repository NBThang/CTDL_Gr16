package model.manager;

import model.objects.Book;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ManagerUser {
    private String driver = "com.microsoft.sqlserver.jdbc.SQLSeverDriver";
    private String url = "jdbc:mySQL://localhost:3306/bookdata";
    private String user = "root";
    private String password = "";
    private Statement st;
    private ResultSet rs;
    private void remoteSQL(Book b) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection(url, user, password);

            java.sql.Statement st = con.createStatement();
            String sql = "INSERT INTO BOOK (id, tensach, tacgia, theloai)" +
                    " VALUES("+b.getIdBook()+" , "+b.getNameBook()+" , "+b.getAuthor()+" , "+b.getCategory()+")";

            int resuil = st.executeUpdate(sql);

        } catch (Exception e){

        }
    }
}
