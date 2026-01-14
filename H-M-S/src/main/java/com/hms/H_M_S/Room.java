package com.hms.H_M_S;

import java.sql.*;
import java.util.Scanner;

public class Room {

    // 🔹 ADD ROOM
    public static void addRoom() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Room Type: ");
        String type = sc.nextLine();

        System.out.print("Charge: ");
        double charge = sc.nextDouble();
        sc.nextLine();

        System.out.print("Status (Available/Occupied): ");
        String status = sc.nextLine();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO room(room_type, charge, status) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, type);
            ps.setDouble(2, charge);
            ps.setString(3, status);

            ps.executeUpdate();
            System.out.println("Room Added Successfully ✅");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 VIEW ROOMS (TABLE FORMAT)
    public static void viewRooms() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM room");

            System.out.println("+----------+---------------+------------+------------+");
            System.out.println("| Room Id  | Room Type     | Charge     | Status     |");
            System.out.println("+----------+---------------+------------+------------+");

            while (rs.next()) {
                System.out.printf(
                    "| %-8d | %-13s | %-10.2f | %-10s |\n",
                    rs.getInt("room_id"),
                    rs.getString("room_type"),
                    rs.getDouble("charge"),
                    rs.getString("status")
                );
            }

            System.out.println("+----------+---------------+------------+------------+");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 DELETE ROOM
    public static void deleteRoom() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Room ID to Delete: ");
        int id = sc.nextInt();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                con.prepareStatement("DELETE FROM room WHERE room_id=?");

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Room Deleted Successfully ✅");
            else
                System.out.println("Room ID Not Found ❌");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
