package com.hms.H_M_S;

import java.sql.*;
import java.util.Scanner;

public class Doctor {

    // 🔹 ADD DOCTOR
    public static void addDoctor() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Doctor Name: ");
        String name = sc.nextLine();

        System.out.print("Specialization: ");
        String spec = sc.nextLine();

        System.out.print("Contact: ");
        String contact = sc.nextLine();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO doctor(name, specialization, contact) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, spec);
            ps.setString(3, contact);

            ps.executeUpdate();
            System.out.println("Doctor Added Successfully ✅");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 VIEW ALL DOCTORS (TABLE FORMAT)
    public static void viewDoctors() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM doctor");

            System.out.println("+------------+-----------------+----------------------+------------+");
            System.out.println("| Doctor Id  | Name            | Specialization       | Contact    |");
            System.out.println("+------------+-----------------+----------------------+------------+");

            while (rs.next()) {
                System.out.printf(
                    "| %-10d | %-15s | %-20s | %-10s |\n",
                    rs.getInt("doctor_id"),
                    rs.getString("name"),
                    rs.getString("specialization"),
                    rs.getString("contact")
                );
            }

            System.out.println("+------------+-----------------+----------------------+------------+");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 DELETE DOCTOR
    public static void deleteDoctor() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Doctor ID to Delete: ");
        int id = sc.nextInt();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                con.prepareStatement("DELETE FROM doctor WHERE doctor_id=?");

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Doctor Deleted Successfully ✅");
            else
                System.out.println("Doctor ID Not Found ❌");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
