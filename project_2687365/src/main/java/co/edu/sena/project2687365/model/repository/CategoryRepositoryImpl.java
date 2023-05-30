package co.edu.sena.project2687365.model.repository;

import co.edu.sena.project2687365.model.Category;
import co.edu.sena.project2687365.model.User;
import co.edu.sena.project2687365.util.connectionTest.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements Repository<Category>{
    private String sql = null;

    @Override
    public List<Category> listAllObj() throws SQLException {
        sql = "SELECT * FROM category_tbl ORDER BY category_name";
        List<Category> categories = new ArrayList<>();
        try(Connection conn = ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Category c =  createObj(rs);
                categories.add(c);
            }
        }
        return categories;
    }

    @Override
    public Category byIdObj(Integer id) throws SQLException {
        sql = "SELECT * FROM category_tbl WHERE category_id = ?";
        Category category = null;

        try(Connection conn = ConnectionPool.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    category = createObj(rs);
                }
            }
        }
        return category;
    }

    @Override
    public Integer saveObj(Category category) throws SQLException {
        int rowsAffected = 0;

        if(category.getCategory_id() != null && category.getCategory_id() > 0){
            sql= "UPDATE category_tbl SET category_name = ? WHERE category_id = ?";
        }else{
            sql= "INSERT INTO category_tbl (category_name) VALUES (?)";
        }

        try(Connection conn = ConnectionPool.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,category.getCategory_name());
            if (category.getCategory_id() != null && category.getCategory_id() > 0){
                    ps.setInt(2,category.getCategory_id());
            }

            rowsAffected = ps.executeUpdate();
        }
        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql = "DELETE FROM category_tbl WHERE category_id = ?";
        try(Connection conn = ConnectionPool.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
    }

    @Override
    public Category createObj(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setCategory_id(rs.getInt("category_id"));
        category.setCategory_name(rs.getString("category_name"));
        return category;
    }
}
