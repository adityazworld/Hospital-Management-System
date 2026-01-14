package com.hms.H_M_S;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hms_db",
                "root",            // username
                "##Aditya##"      // password
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
