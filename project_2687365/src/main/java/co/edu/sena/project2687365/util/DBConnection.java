package co.edu.sena.project2687365.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL =
            "jdbc:mysql://localhost:3306/my_app?serverTimezone=America/Bogota";
    private static final String USER = "root";
    private static final String PASS = "password09";

    private static BasicDataSource pool;
    public static BasicDataSource getInstance() throws SQLException {
        if (pool == null){
           pool = new BasicDataSource();
           pool.setUrl(URL);
            pool.setUsername(USER);
            pool.setPassword(PASS);

            pool.setInitialSize(3);
            pool.setMinIdle(3);
            pool.setMaxIdle(8);
            pool.setMaxTotal(8);


        }

        return pool;
    }//getConnectionToDatabase

    public static Connection getConnection() throws SQLException{
        return getInstance().getConnection();
    }
}
