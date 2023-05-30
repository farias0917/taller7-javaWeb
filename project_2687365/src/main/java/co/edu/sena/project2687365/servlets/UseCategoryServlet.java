package co.edu.sena.project2687365.servlets;

import co.edu.sena.project2687365.model.Category;
import co.edu.sena.project2687365.model.repository.CategoryRepositoryImpl;
import co.edu.sena.project2687365.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/categoryForm")
public class UseCategoryServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //todo collet all from data
        String category_name = request.getParameter("category_name");

        //todo fill it up in a user bean
        Category category = new Category(category_name);

        //todo call repository layer and save the user objet db
        Repository<Category> repository = new CategoryRepositoryImpl();
        int rows = 0;
        try{
            rows=repository.saveObj(category);
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
