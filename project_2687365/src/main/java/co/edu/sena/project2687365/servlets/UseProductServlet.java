package co.edu.sena.project2687365.servlets;
import co.edu.sena.project2687365.model.Category;
import co.edu.sena.project2687365.model.Product;
import co.edu.sena.project2687365.model.repository.ProductRepositoryImpl;
import co.edu.sena.project2687365.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/productForm")
public class UseProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String product_name = request.getParameter("product_name");
        int product_value = Integer.parseInt(request.getParameter("product_value"));
        int category_id = Integer.parseInt(request.getParameter("category_id"));

        Product product = new Product(product_name,product_value,category_id);

        //todo call repository layer and save the user objet db
        Repository<Product> repository = new ProductRepositoryImpl();
        int rows = 0;
        try{
            rows=repository.saveObj(product);
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

