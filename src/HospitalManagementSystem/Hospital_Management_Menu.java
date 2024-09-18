package HospitalManagementSystem;

import java.sql.*;
import java.util.Scanner;

public class Hospital_Management_Menu {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/hospital";
    private static final String username = "root";
    private static final String password = "minhajuldb@15";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Scanner scanner = new Scanner(System.in);

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Patient patient = new Patient(connection,scanner);
            Doctor doctor = new Doctor(connection);
            while (true){
                System.out.println("HOSPITAL MANAGEMENT SYSTEM");
                System.out.println("1. Add Patients");
                System.out.println("2. View Patients");
                System.out.println("3. View Doctors");
                System.out.println("4. Book Appointment");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice){
                    case 1:
                        patient.addPatients();
                        System.out.println();
                        break;
                    case 2:
                        patient.viewPatients();
                        System.out.println();
                        break;
                    case 3:
                        doctor.viewDoctors();
                        System.out.println();
                        break;
                    case 4:
                        appointment(patient,doctor,scanner,connection);
                        System.out.println();
                        break;
                    case 5:
                        System.out.println("Thanks For Using Hospital Management System!!!)");
                        return;
                    default:
                        System.out.println("Invalid Choice, Try again... ");
                        break;


                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void appointment(Patient patient, Doctor doctor, Scanner scanner, Connection connection) {
        System.out.print("Enter patient ID : ");
        int patient_id = scanner.nextInt();
        System.out.print("Enter Doctor ID : ");
        int doctor_id = scanner.nextInt();
        System.out.print("Enter Appointment Date(YYYY-MM-DD) : ");
        String date = scanner.next();

        if (patient.getPatientById(patient_id) && doctor.getDoctorById(doctor_id)){
            if (checkAvailability(doctor_id , date , connection)){
                String query = "INSERT INTO appointments(patient_id, doctor_id, appointment_date) VALUES(?,?,?)";
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setInt(1,patient_id);
                    preparedStatement.setInt(2,doctor_id);
                    preparedStatement.setString(3,date);

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0){
                        System.out.println("Appointment Booked Successfully");
                    } else {
                        System.out.println("Failed to Book Appointment");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("Doctor is not available on this date...");
            }
        }
        else {
            System.out.println("Either Doctor or Patient does not exist...");
        }
    }

    private static boolean checkAvailability(int doctorId, String date, Connection connection) {
        String query = "SELECT COUNT(*) FROM appointments WHERE doctor_id = ? AND appointment_date = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,doctorId);
            preparedStatement.setString(2,date);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int count = resultSet.getInt(1);
                if (count==0){
                    return true;
                }
                else {
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
