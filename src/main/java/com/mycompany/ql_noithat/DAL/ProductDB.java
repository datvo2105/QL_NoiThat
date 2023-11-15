package com.mycompany.ql_noithat.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    public List<Product> getAllProducts(String search) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = DB.getConnect().prepareStatement("SELECT * FROM TABLE(DEV.GET_PRODUCTS(?))");
            statement.setString(1, search);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product supplier = new Product();
                supplier.setProductId(resultSet.getInt("PRODUCT_ID"));
                supplier.setProductName(resultSet.getString("PRODUCT_NAME"));
                supplier.setCategoryId(resultSet.getInt("CATEGORY_ID"));
                supplier.setPrice(resultSet.getDouble("PRICE"));
                supplier.setDesc(resultSet.getString("DESCRIPTION"));
                products.add(supplier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    public boolean createProduct(Product product) {
        String insertQuery = "{CALL DEV.ADDPRODUCT(?,?,?,?)}";

        try (
                PreparedStatement statement = DB.getConnect().prepareCall(insertQuery)) {
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getCategoryId());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getDesc());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateProduct(Product product) {
        String insertQuery = "{CALL DEV.UPDATEPRODUCT(?,?,?,?,?)}";

        try (
                PreparedStatement statement = DB.getConnect().prepareCall(insertQuery)) {
            statement.setInt(1, product.getProductId());
            statement.setString(2, product.getProductName());
            statement.setInt(3, product.getCategoryId());
            statement.setDouble(4, product.getPrice());
            statement.setString(5, product.getDesc());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteProduct(int id) {
        String insertQuery = "{CALL DEV.DELETEPRODUCT(?)}";

        try (
                PreparedStatement statement = DB.getConnect().prepareCall(insertQuery)) {
            statement.setInt(1, id);
            int rowsInserted = statement.executeUpdate();

            // Check if the insertion was successful
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Insertion failed
        }
    }

}
