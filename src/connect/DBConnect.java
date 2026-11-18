package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    public static Connection getConnection() {

        try {

            String url =
                "jdbc:sqlserver://localhost;"
                + "databaseName=QuanLySinhVien;"
                + "encrypt=true;"
                + "trustServerCertificate=true;";

            return DriverManager.getConnection(
                    url,
                    "sa",
                    "dungpho07"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}