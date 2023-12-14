package com.diegomd.basiccrmproject.repository;

import com.diegomd.basiccrmproject.domain.entities.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private final DatabaseConnection connection;

    public ProductRepository() {
        this.connection = DatabaseConnection.getInstance();
    }

    public boolean save(Product product) throws SQLException {
        String saveSQL = "INSERT INTO products (name, description, price, image_url) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = connection.getConnection().prepareStatement(saveSQL);

        stmt.setString(1, product.getName());
        stmt.setString(2, product.getDescription());
        stmt.setDouble(3, product.getPrice());
        stmt.setString(4, product.getImageUrl());

        return stmt.execute();
    }

    public Product findById(Integer id) throws SQLException {
        Product product = null;

        String findSQL = "SELECT * FROM products WHERE id = ?";

        PreparedStatement stmt = connection.getConnection().prepareStatement(findSQL);
        stmt.setInt(1, id);

        ResultSet resultSet = stmt.executeQuery();
        if (resultSet.next()) {
            product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setPrice(resultSet.getDouble("price"));
            product.setImageUrl(resultSet.getString("image_url"));
        }

        return product;
    }

    public List<Product> findAll() throws SQLException {
        List<Product> allProducts = new ArrayList<>();

        PreparedStatement stmt = connection.getConnection().prepareStatement("SELECT * FROM products");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            Product product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setPrice(resultSet.getDouble("price"));
            product.setImageUrl(resultSet.getString("image_url"));
            allProducts.add(product);
        }
        return allProducts;
    }

    public boolean update(Product product) throws SQLException {
        if (product == null || product.getId() <= 0)
            return false;

        String updateSQL = "UPDATE products SET " +
                "name = ?," +
                "description = ?," +
                "price = ?," +
                "image_url = ? " +
                "WHERE id = ?";

        PreparedStatement stmt = connection.getConnection().prepareStatement(updateSQL);
        stmt.setString(1, product.getName());
        stmt.setString(2, product.getDescription());
        stmt.setDouble(3, product.getPrice());
        stmt.setString(4, product.getImageUrl());
        stmt.setInt(5, product.getId());

        return stmt.execute();
    }

    public boolean deleteById(Integer id) throws SQLException {
        String deleteSQL = "DELETE FROM products WHERE id = ?";
        PreparedStatement stmt = connection.getConnection().prepareStatement(deleteSQL);
        stmt.setInt(1, id);
        return stmt.execute();
    }
}