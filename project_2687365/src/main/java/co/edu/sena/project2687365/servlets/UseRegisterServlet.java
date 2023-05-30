package co.edu.sena.project2687365.servlets;

import co.edu.sena.project2687365.model.User;
import co.edu.sena.project2687365.model.repository.Repository;
import co.edu.sena.project2687365.model.repository.UserRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registerForm")

public class UseRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  collet all from data
        String user_firstname = request.getParameter("user_firstname");
        String user_lastname = request.getParameter("user_lastname");
        String user_email = request.getParameter("user_email");
        String user_password = request.getParameter("user_password");

        //todo fill it up in a user bean
        User user = new User(user_firstname,user_lastname,user_email,user_password);
        //todo call repository layer and save the user objet db
        Repository<User> repository = new UserRepositoryImpl();
        int rows = 0;
        try{
            rows=repository.saveObj(user);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        //todo prepare an information message for user abot succes or failure of the operation
        String infMessage= null;
        if(rows==0){
            System.out.println("Ocurrio un error");
        }else {
            System.out.println("Registro exitoso");
        }

    }
}
