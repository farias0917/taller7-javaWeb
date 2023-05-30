package co.edu.sena.project2687365.model.repository;


import co.edu.sena.project2687365.model.Category;

import java.sql.*;

public class TestCategoryRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        Repository<Category> repository = new CategoryRepositoryImpl();

        System.out.println("//----- saveObj Insert -----//");
        Category categoryInsert = new Category();
        categoryInsert.setCategory_name("Frutas");
        repository.saveObj(categoryInsert);
        categoryInsert.setCategory_name("Paquetes");
        repository.saveObj(categoryInsert);

        System.out.println("//----- listAllObj  -----//");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("//----- byIdObj -----//");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("//----- saveObj-----//");
        Category categoryUpdate = new Category();
        categoryUpdate.setCategory_id(2);
        categoryUpdate.setCategory_name("Granos");
        repository.saveObj((categoryUpdate));
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("//----- deleteObj -----//");
        repository.deleteObj(3);
        repository.listAllObj().forEach(System.out::println);
    }
}
