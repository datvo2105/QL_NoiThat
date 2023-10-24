package com.mycompany.ql_noithat.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDB {
    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement statement = DB.getConnect().prepareStatement("SELECT * FROM TABLE(GET_PRODUCT_C(''))");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("CATEGORY_ID"));
                category.setCategoryName(resultSet.getString("CATEGORY_NAME"));
                categories.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }

    public boolean createCategory(Category category) {
        String insertQuery = "{CALL ADDPRODUCTCATEGORY(?)}";

        try (
                PreparedStatement statement = DB.getConnect().prepareCall(insertQuery)) {
            statement.setString(1, category.getCategoryName());

            int rowsInserted = statement.executeUpdate();

            // Check if the insertion was successful
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Insertion failed
        }
    }

    public boolean updateCategory(Category category) {
        String insertQuery = "{CALL UPDATEPRODUCTCATEGORY(?,?)}";

        try (
                PreparedStatement statement = DB.getConnect().prepareCall(insertQuery)) {
            statement.setInt(1, category.getCategoryId());
            statement.setString(2, category.getCategoryName());

            int rowsInserted = statement.executeUpdate();

            // Check if the insertion was successful
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Insertion failed
        }
    }

    public boolean deleteCategory(int id) {
        String insertQuery = "{CALL DELETEPRODUCTCATEGORY(?)}";

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
