package com.mycompany.ql_noithat.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserKeys {
    public boolean saveKey(String userName, String privateKey, String publicKey) {
        try {
            Connection connection = DB.getConnect();

            String checkQuery = "SELECT COUNT(*) FROM UserKeys WHERE userName = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkQuery)) {
                checkStatement.setString(1, userName);
                try (ResultSet resultSet = checkStatement.executeQuery()) {
                    resultSet.next();
                    int count = resultSet.getInt(1);

                    if (count > 0) {
                        // userName exists, update private and public keys
                        String updateQuery = "UPDATE UserKeys SET privateKey = ?, publicKey = ? WHERE userName = ?";
                        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                            updateStatement.setString(1, privateKey);
                            updateStatement.setString(2, publicKey);
                            updateStatement.setString(3, userName);
                            updateStatement.executeUpdate();
                        }
                    } else {
                        // userName does not exist, create a new entry
                        String insertQuery = "INSERT INTO UserKeys (userName, privateKey, publicKey) VALUES (?, ?, ?)";
                        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                            insertStatement.setString(1, userName);
                            insertStatement.setString(2, privateKey);
                            insertStatement.setString(3, publicKey);
                            insertStatement.executeUpdate();
                        }
                    }
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean Validate(String username, String cryptString) {
        try {
            Connection connection = DB.getConnect();

            String checkQuery = "SELECT * FROM UserKeys WHERE userName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(checkQuery);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String userName = resultSet.getString("userName");
                String privateKey = resultSet.getString("privateKey");
                String publicKey = resultSet.getString("publicKey");

                RSAManager rsaManager = new RSAManager(privateKey, publicKey);

                return rsaManager.decrypt(cryptString) == userName;

            }

            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
