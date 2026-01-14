package com.hms.H_M_S;

import java.sql.*;
import java.util.Scanner;

public class Appointment {

    public static void bookAppointment() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Patient ID: ");
        int pid = sc.nextInt();
        System.out.print("Doctor ID: ");
        int did = sc.nextInt();
        System.out.print("Date (YYYY-MM-DD): ");
        String date = sc.next();
        System.out.print("Time (HH:MM:SS): ");
        String time = sc.next();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                con.prepareStatement(
                "INSERT INTO appointment(patient_id,doctor_id,date,time) VALUES(?,?,?,?)"
                );
            ps.setInt(1, pid);
            ps.setInt(2, did);
            ps.setString(3, date);
            ps.setString(4, time);
            ps.executeUpdate();

            System.out.println("Appointment Booked!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
