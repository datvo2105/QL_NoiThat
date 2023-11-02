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
            PreparedStatement statement = DB.getConnect().prepareStatement(
                    "SELECT * FROM ALL_USERS WHERE ALL_USERS.ORACLE_MAINTAINED = 'N' AND USERNAME != 'SCOTT'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setUserName(resultSet.getString("USERNAME"));
                user.setPassword("");
                user.setCreateAt(resultSet.getString("CREATED"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public boolean createUserKhachHang(User user) {
        String insertQuery = "{CALL CREATE_USER_KHACH_HANG(?,?)}";

        try (
                PreparedStatement statement = DB.getConnect().prepareCall(insertQuery)) {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createUserQuanLi(User user) {
        String insertQuery = "{CALL CREATE_USER_QUAN_LI(?,?)}";

        try (
                PreparedStatement statement = DB.getConnect().prepareCall(insertQuery)) {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
