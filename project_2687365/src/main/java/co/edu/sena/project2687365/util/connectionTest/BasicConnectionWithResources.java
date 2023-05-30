package co.edu.sena.project2687365.util.connectionTest;

import java.sql.*;

public class BasicConnectionWithResources {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/myApp?serverTimezone=America/Bogota";
        String userName = "root";
        String password = "";

        String sql = "SELECT * FROM MyApp.users_tbl";

        try {
            Connection conn = DriverManager.getConnection(url,userName,password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                System.out.println("Nombre: " + rs.getString("user_firstname"));

                System.out.println("Apellido: " + rs.getString("user_lastname"));

                System.out.println("");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
