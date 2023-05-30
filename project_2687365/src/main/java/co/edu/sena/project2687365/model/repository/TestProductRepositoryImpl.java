package co.edu.sena.project2687365.model.repository;

import co.edu.sena.project2687365.model.Product;
import co.edu.sena.project2687365.model.User;

import java.sql.SQLException;

public class TestProductRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        Repository<Product> repository = new ProductRepositoryImpl();

        System.out.println("//----- saveObj Insert -----//");

        Product productInsert = new Product();
        productInsert.setProduct_name("Manzana");
        productInsert.setProduct_value(1200);
        productInsert.setCategory_id(1);
        repository.saveObj(productInsert);

        productInsert.setProduct_name("Manzana");
        productInsert.setProduct_value(1200);
        productInsert.setCategory_id(1);
        repository.saveObj(productInsert);

        productInsert.setProduct_name("durazno");
        productInsert.setProduct_value(1200);
        productInsert.setCategory_id(1);
        repository.saveObj(productInsert);

        System.out.println("//----- listAllObj  -----//");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("//----- byIdObj -----//");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("//----- saveObj-----//");
        Product productUpdate = new Product();
        productUpdate.setProduct_id(6);
        productUpdate.setProduct_name("Arroz");
        productUpdate.setProduct_value(1500);
        productUpdate.setCategory_id(2);
        repository.saveObj(productUpdate);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("//----- deleteObj -----//");
        repository.deleteObj(7);
        repository.listAllObj().forEach(System.out::println);
    }
}
