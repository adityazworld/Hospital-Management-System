package com.hms.H_M_S;

import java.sql.*;
import java.util.Scanner;

public class Patient {

    // 🔹 ADD PATIENT
    public static void addPatient() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Gender: ");
        String gender = sc.nextLine();

        System.out.print("Contact: ");
        String contact = sc.nextLine();

        System.out.print("Disease: ");
        String disease = sc.nextLine();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO patient(name,age,gender,contact,disease) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setString(4, contact);
            ps.setString(5, disease);

            ps.executeUpdate();
            System.out.println("Patient Added Successfully ✅");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 VIEW ALL PATIENTS (TABLE FORMAT)
    public static void viewPatients() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patient");

            System.out.println("+------------+-----------------+--------+--------+--------------+-----------------+");
            System.out.println("| Patient Id | Name            | Age    | Gender | Contact      | Disease         |");
            System.out.println("+------------+-----------------+--------+--------+--------------+-----------------+");

            while (rs.next()) {
                System.out.printf(
                    "| %-10d | %-15s | %-6d | %-6s | %-12s | %-15s |\n",
                    rs.getInt("patient_id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("contact"),
                    rs.getString("disease")
                );
            }

            System.out.println("+------------+-----------------+--------+--------+--------------+-----------------+");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 DELETE PATIENT
    public static void deletePatient() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Patient ID to Delete: ");
        int id = sc.nextInt();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                con.prepareStatement("DELETE FROM patient WHERE patient_id=?");

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Patient Deleted Successfully ✅");
            else
                System.out.println("Patient ID Not Found ❌");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
