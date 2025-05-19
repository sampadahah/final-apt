package com.aptcoursework.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.aptcoursework.controller.database.DatabaseConnection;
import com.aptcoursework.model.Product;

public class UserProductDAO {
    private Connection conn;

    public UserProductDAO() throws ClassNotFoundException, SQLException {
        this.conn = DatabaseConnection.getConnection();
    }
    
    public List<Product> getCleansers() throws SQLException {
        List<Product> cleansers = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product_name LIKE ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%Cleanser%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setDescription(rs.getString("product_description"));
                p.setPrice(rs.getDouble("price"));
                p.setImagePath(rs.getString("imagepath"));
                cleansers.add(p);
            }
        }
        return cleansers;
    }

    public List<Product> getMoisturizers() throws SQLException {
        List<Product> moisturizers = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product_name LIKE ?"; 
        try (PreparedStatement ps= conn.prepareStatement(sql)) {
            ps.setString(1, "%Moist%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setDescription(rs.getString("product_description"));
                p.setPrice(rs.getDouble("price"));
                p.setImagePath(rs.getString("imagepath"));
                moisturizers.add(p);
            }
        }
        return moisturizers;
    }
    
    public List<Product> getSerum() throws SQLException {
        List<Product> serum= new ArrayList<>();
        String sql= "SELECT * FROM product WHERE product_name LIKE ?"; 
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%Serum%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setDescription(rs.getString("product_description"));
                p.setPrice(rs.getDouble("price"));
                p.setImagePath(rs.getString("imagepath"));
                serum.add(p);
            }
        }
        return serum;
    }
    public List<Product> getSunscreen() throws SQLException {
        List<Product> sunscreen= new ArrayList<>();
        String sql= "SELECT * FROM product WHERE product_name LIKE ?"; 
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%SPF%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setDescription(rs.getString("product_description"));
                p.setPrice(rs.getDouble("price"));
                p.setImagePath(rs.getString("imagepath"));
                sunscreen.add(p);
            }
        }
        return sunscreen;
    }
}
