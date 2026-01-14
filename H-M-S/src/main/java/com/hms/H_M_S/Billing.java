package com.hms.H_M_S;

import java.sql.*;
import java.util.Scanner;

public class Billing {

    // 🔹 GENERATE BILL
    public static void generateBill() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Patient ID: ");
        int pid = sc.nextInt();

        System.out.print("Room Charge: ");
        double rc = sc.nextDouble();

        System.out.print("Medicine Charge: ");
        double mc = sc.nextDouble();

        System.out.print("Doctor Fee: ");
        double df = sc.nextDouble();

        double total = rc + mc + df;

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO billing(patient_id, room_charge, medicine_charge, doctor_fee, total) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, pid);
            ps.setDouble(2, rc);
            ps.setDouble(3, mc);
            ps.setDouble(4, df);
            ps.setDouble(5, total);

            ps.executeUpdate();

            System.out.println("Bill Generated Successfully ✅");
            System.out.println("Total Amount = ₹" + total);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 VIEW BILLS (TABLE FORMAT)
    public static void viewBills() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM billing");

            System.out.println("+----------+------------+--------------+-------------------+-------------+------------+");
            System.out.println("| Bill Id  | Patient Id | Room Charge  | Medicine Charge   | Doctor Fee | Total      |");
            System.out.println("+----------+------------+--------------+-------------------+-------------+------------+");

            while (rs.next()) {
                System.out.printf(
                    "| %-8d | %-10d | %-12.2f | %-17.2f | %-11.2f | %-10.2f |\n",
                    rs.getInt("bill_id"),
                    rs.getInt("patient_id"),
                    rs.getDouble("room_charge"),
                    rs.getDouble("medicine_charge"),
                    rs.getDouble("doctor_fee"),
                    rs.getDouble("total")
                );
            }

            System.out.println("+----------+------------+--------------+-------------------+-------------+------------+");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
