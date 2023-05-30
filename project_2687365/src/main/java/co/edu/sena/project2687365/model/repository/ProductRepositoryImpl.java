package co.edu.sena.project2687365.model.repository;

import co.edu.sena.project2687365.model.Category;
import co.edu.sena.project2687365.model.Product;
import co.edu.sena.project2687365.model.User;
import co.edu.sena.project2687365.util.connectionTest.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements Repository<Product>{

    private String sql = null;
    @Override
    public List<Product> listAllObj() throws SQLException {
        sql = "SELECT * FROM products_tbl ORDER BY product_name";
        List<Product> products = new ArrayList<>();
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Product p =  createObj(rs);
                products.add(p);
            }
        }
        return products;
    }

    @Override
    public Product byIdObj(Integer id) throws SQLException {
        sql = "SELECT * FROM products_tbl WHERE product_id = ?";
        Product product = null;

        try(Connection conn = ConnectionPool.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    product = createObj(rs);
                }
            }
        }
        return product;
    }

    @Override
    public Integer saveObj(Product product) throws SQLException {
        int rowsAffected = 0;

        if(product.getProduct_id() != null && product.getProduct_id() > 0){
            sql= "UPDATE products_tbl SET product_name = ?,product_value = ?," +
                    "category_id = ? WHERE product_id = ?";
        }else{
            sql= "INSERT INTO products_tbl (product_name,product_value,category_id) " +
                    "VALUES (?,?,?)";
        }

        try(Connection conn = ConnectionPool.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,product.getProduct_name());
            ps.setInt(2,product.getProduct_value());
            ps.setInt(3,product.getCategory_id());
            if (product.getProduct_id() != null && product.getProduct_id() > 0){
                ps.setInt(4,product.getProduct_id());
            }

            rowsAffected = ps.executeUpdate();
        }
        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql = "DELETE FROM products_tbl WHERE product_id = ?";
        try(Connection conn = ConnectionPool.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
    }

    @Override
    public Product createObj(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setProduct_id(rs.getInt("product_id"));
        product.setProduct_name(rs.getString("product_name"));
        product.setProduct_value(rs.getInt("product_value"));
        product.setCategory_id(rs.getInt("category_id"));
        return product;
    }
}
