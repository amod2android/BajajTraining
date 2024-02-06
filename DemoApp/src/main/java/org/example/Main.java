package org.example;

import org.example.student.Student;
import org.example.student.StudentController;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter How many student you want ? ");
        int n=scanner.nextInt();


        StudentController studentController=new StudentController();
        for(int i=0 ;i<n;i++) {
            studentController.create();
        }
        studentController.display();


    }
}