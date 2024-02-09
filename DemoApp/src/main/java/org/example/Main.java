package org.example;

import org.example.student.StudentController;
import org.example.student.StudentGateway;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DBConnection dbConnection = new DBConnection();
        StudentGateway studentGateway = new StudentGateway(dbConnection);
        StudentController studentController = new StudentController(studentGateway);
        int conti;

        do {
            System.out.println("Choose the operation");
            System.out.println("1. Create Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. View All Student");
            System.out.println("5. Search By Name");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    studentController.create();
                    break;
                }
                case 2: {
                    studentController.delete();
                    break;
                }
                case 3: {
                    studentController.update();
                    break;
                }
                case 4: {
                    studentController.getAll();
                    break;
                }
                case 5: {
                    studentController.searchByName();
                    break;
                }
                default: {
                    System.out.println("Invalid Option");
                }
            }
            System.out.println("Do you want to continue operation 1 - yes / 0 - no");
            conti = scanner.nextInt();
        }
        while (conti == 1);
    }
}