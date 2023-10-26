package com.mycompany.ql_noithat.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDB {
    public List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        try {
            PreparedStatement statement = DB.getConnect().prepareStatement("SELECT * FROM TABLE(DEV.GET_SUPPLIER(''))");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Supplier supplier = new Supplier();
                supplier.setSupplierId(resultSet.getInt("SUPPLIER_ID"));
                supplier.setSupplierName(resultSet.getString("SUPPLIER_NAME"));
                supplier.setContactName(resultSet.getString("CONTACT_NAME"));
                supplier.setContactEmail(resultSet.getString("CONTACT_EMAIL"));
                supplier.setContactPhone(resultSet.getString("CONTACT_PHONE"));
                supplier.setAddress(resultSet.getString("ADDRESS"));
                supplier.setCity(resultSet.getString("CITY"));
                supplier.setState(resultSet.getString("STATE"));
                supplier.setPostalCode(resultSet.getString("POSTAL_CODE"));
                supplier.setCountry(resultSet.getString("COUNTRY"));

                suppliers.add(supplier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return suppliers;
    }

    public boolean createSupplier(Supplier supplier) {
        String insertQuery = "{CALL DEV.INSERTSUPPLIER(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (
                PreparedStatement statement = DB.getConnect().prepareCall(insertQuery)) {
            statement.setString(1, supplier.getSupplierName());
            statement.setString(2, supplier.getContactName());
            statement.setString(3, supplier.getContactEmail());
            statement.setString(4, supplier.getContactPhone());
            statement.setString(5, supplier.getAddress());
            statement.setString(6, supplier.getCity());
            statement.setString(7, supplier.getState());
            statement.setString(8, supplier.getPostalCode());
            statement.setString(9, supplier.getCountry());

            int rowsInserted = statement.executeUpdate();

            // Check if the insertion was successful
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Insertion failed
        }
    }

    public boolean updateSupplier(Supplier supplier) {
        String insertQuery = "{CALL DEV.UPDATESUPPLIER(?,?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (
                PreparedStatement statement = DB.getConnect().prepareCall(insertQuery)) {
            statement.setInt(1, supplier.getSupplierId());
            statement.setString(2, supplier.getSupplierName());
            statement.setString(3, supplier.getContactName());
            statement.setString(4, supplier.getContactEmail());
            statement.setString(5, supplier.getContactPhone());
            statement.setString(6, supplier.getAddress());
            statement.setString(7, supplier.getCity());
            statement.setString(8, supplier.getState());
            statement.setString(9, supplier.getPostalCode());
            statement.setString(10, supplier.getCountry());

            int rowsInserted = statement.executeUpdate();

            // Check if the insertion was successful
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Insertion failed
        }
    }

    public boolean deleteSupplier(int id) {
        String insertQuery = "{CALL DEV.DELETESUPPLIERBYID(?)}";

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
