/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ql_noithat.DAL;

import java.sql.*;

/**
 *
 * @author vogiadat
 */
public class DB {

    public static Connection conn;
    public static String user = "";
    public static String pass = "";
    public static String url = "jdbc:oracle:thin:@";
    public static String server = "localhost:1521:orcl";

    public static Connection connect() {
        try {
            if (user.equalsIgnoreCase("sys")) {
                user += " as sysdba";
            }
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url + server, user, pass);
            Statement statement = conn.createStatement();
            statement.execute("ALTER SESSION SET \"_ORACLE_SCRIPT\"=true");
            statement.close();

            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public static Connection getConnect() {
        if (conn != null) {
            return conn;
        }
        return connect();
    }

    public static Connection disconnect() {
        user = "";
        pass = "";
        return connect();
    }
}
