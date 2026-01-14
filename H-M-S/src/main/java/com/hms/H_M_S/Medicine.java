package com.hms.H_M_S;

import java.sql.*;
import java.util.Scanner;

public class Medicine {

    // 🔹 ADD MEDICINE
    public static void addMedicine() {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Medicine Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int qty = sc.nextInt();

            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO medicine(name, price, quantity) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, qty);

            ps.executeUpdate();
            System.out.println("✅ Medicine Added Successfully");

        } catch (Exception e) {
            System.out.println("❌ Invalid Input! Please enter correct data.");
            sc.nextLine(); // clear buffer
        }
    }

    // 🔹 VIEW MEDICINES
    public static void viewMedicines() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM medicine");

            System.out.println("+------------+-----------------+------------+----------+");
            System.out.println("| MedicineId | Name            | Price      | Quantity |");
            System.out.println("+------------+-----------------+------------+----------+");

            while (rs.next()) {
                System.out.printf(
                        "| %-10d | %-15s | %-10.2f | %-8d |\n",
                        rs.getInt("medicine_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
            }

            System.out.println("+------------+-----------------+------------+----------+");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 DELETE MEDICINE
    public static void deleteMedicine() {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Medicine ID to Delete: ");
            int id = sc.nextInt();

            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement("DELETE FROM medicine WHERE medicine_id=?");

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("✅ Medicine Deleted Successfully");
            else
                System.out.println("❌ Medicine ID Not Found");

        } catch (Exception e) {
            System.out.println("❌ Please enter valid numeric ID.");
            sc.nextLine(); // clear buffer
        }
    }
}
