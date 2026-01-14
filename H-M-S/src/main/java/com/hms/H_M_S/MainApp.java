package com.hms.H_M_S;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        // ===== LOGIN FIRST (ROLE BASED) =====
        String role = UserLogin.login();

        if (role == null) {
            System.out.println("Exiting System...");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int ch;

        while (true) {

            System.out.println("\n================= HOSPITAL MANAGEMENT SYSTEM =================");

            // ===== ADMIN MENU =====
            if (role.equalsIgnoreCase("ADMIN")) {

                System.out.println("1.  Add Patient");
                System.out.println("2.  View Patients");
                System.out.println("3.  Delete Patient");

                System.out.println("4.  Add Doctor");
                System.out.println("5.  View Doctors");
                System.out.println("6.  Delete Doctor");

                System.out.println("7.  Add Medicine");
                System.out.println("8.  View Medicines");
                System.out.println("9.  Delete Medicine");

                System.out.println("10. Book Appointment");

                System.out.println("11. Add Room");
                System.out.println("12. View Rooms");
                System.out.println("13. Delete Room");

                System.out.println("14. Generate Bill");
                System.out.println("15. View Bills");

                System.out.println("0.  Logout");
            }
            // ===== USER MENU =====
            else {

                System.out.println("1.  View Patients");
                System.out.println("2.  View Doctors");
                System.out.println("3.  View Medicines");
                System.out.println("4.  Book Appointment");
                System.out.println("0.  Logout");
            }

            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            // ===== ADMIN OPERATIONS =====
            if (role.equalsIgnoreCase("ADMIN")) {

                switch (ch) {

                    case 1: Patient.addPatient(); break;
                    case 2: Patient.viewPatients(); break;
                    case 3: Patient.deletePatient(); break;

                    case 4: Doctor.addDoctor(); break;
                    case 5: Doctor.viewDoctors(); break;
                    case 6: Doctor.deleteDoctor(); break;

                    case 7: Medicine.addMedicine(); break;
                    case 8: Medicine.viewMedicines(); break;
                    case 9: Medicine.deleteMedicine(); break;

                    case 10: Appointment.bookAppointment(); break;

                    case 11: Room.addRoom(); break;
                    case 12: Room.viewRooms(); break;
                    case 13: Room.deleteRoom(); break;

                    case 14: Billing.generateBill(); break;
                    case 15: Billing.viewBills(); break;

                    case 0:
                        System.out.println("Logged out successfully 🔓");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("❌ Invalid Choice");
                }
            }
            // ===== USER OPERATIONS =====
            else {

                switch (ch) {

                    case 1: Patient.viewPatients(); break;
                    case 2: Doctor.viewDoctors(); break;
                    case 3: Medicine.viewMedicines(); break;
                    case 4: Appointment.bookAppointment(); break;

                    case 0:
                        System.out.println("Logged out successfully 🔓");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("❌ Invalid Choice");
                }
            }
        }
    }
}
