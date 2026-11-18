package quanlysinhvien;

import connect.DBConnect;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        Connection con = DBConnect.getConnection();

        if (con != null) {
            System.out.println("Ket noi thanh cong!");
        } else {
            System.out.println("Ket noi that bai!");
        }
    }
}
