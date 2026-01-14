package com.hms.H_M_S;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserLogin {

    // Returns role: ADMIN / USER / null
    public static String login() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n========== HMS LOGIN ==========");

        System.out.print("Username: ");
        String user = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT role FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                System.out.println("✅ Login Successful!");
                System.out.println("Logged in as: " + role);
                return role;
            }

        } catch (Exception e) {
            System.out.println("❌ Database Error");
            e.printStackTrace();
        }

        System.out.println("❌ Invalid Username or Password");
        return null;
    }
}
