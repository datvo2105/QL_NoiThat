package com.mycompany.ql_noithat.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDb {
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = DB.getConnect().prepareStatement("SELECT * FROM TABLE(GET_USERS(''))");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("USER_ID"));
                user.setUserName(resultSet.getString("USERNAME"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setFirstName(resultSet.getString("FIRST_NAME"));
                user.setLastName(resultSet.getString("LAST_NAME"));
                user.setEmail(resultSet.getString("EMAIL"));
                user.setRole(resultSet.getString("ROLE"));

                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public boolean createUser(User user) {
        String insertQuery = "{CALL ADD_USER(?,?,?,?,?,?)}";

        try (
                PreparedStatement statement = DB.getConnect().prepareCall(insertQuery)) {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getRole());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUser(User user) {
        String insertQuery = "{CALL UPDATEUSER(?,?,?,?,?)}";

        try (
                PreparedStatement statement = DB.getConnect().prepareCall(insertQuery)) {
            statement.setInt(1, user.getUserId());
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getEmail());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(int id) {
        String insertQuery = "{CALL DELETEUSER(?)}";

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
