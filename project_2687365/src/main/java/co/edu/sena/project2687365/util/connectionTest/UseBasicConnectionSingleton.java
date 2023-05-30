package co.edu.sena.project2687365.util.connectionTest;

import java.sql.*;

public class UseBasicConnectionSingleton {
    public static void main(String[] args) throws SQLException {
        try
            (Connection conn = BasicConnectionSingleton.getInstace();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users_tbl")){

            while(rs.next()){
                System.out.println("Nombre: " + rs.getString("user_firstname"));

                System.out.println("Apellido: " + rs.getString("user_lastname"));

                System.out.println( "");
            }
        }
    }
}
