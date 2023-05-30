package co.edu.sena.project2687365.util.connectionTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasicConnectionSingleton {
    private static String url = "jdbc:mysql://localhost:3306/myApp?serverTimezone=America/Bogota";
    private static String user = "root";
    private static String pass = "";

    private static Connection conn;

    public static  Connection getInstace() throws SQLException{
        if (conn == null){
            conn = DriverManager.getConnection(url,user,pass);
        }
        return conn;
    }
}
