package org.bajajpro;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Car Details ============================
//        Car car=new Car("BMW","BMW X1","2020");
//        System.out.println(car.details());
//        Car car1=new Car("BMW","BMW X1","2095");
//        System.out.println(car1.details());
//        Car car2=new Car("BMW","BMW Z4","2090");
//        System.out.println(car2.details());


        //Area Of Rectangle ============================
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Enter Height");
//        int height=scanner.nextInt();
//        System.out.println("Enter Width");
//        int width=scanner.nextInt();
//        Rectangle rectangle = new Rectangle(height, width);
//        rectangle.displayInfo();
//        rectangle.area();


        //Exception Handling ============================
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Enter Numerator");
//        int numerator=scanner.nextInt();
//        System.out.println("Enter Denominator");
//        int denominator=scanner.nextInt();
//        try {
//            int result = numerator / denominator;
//            System.out.println("Result: " + result);
//        } catch (ArithmeticException ex) {
//            System.out.println("Error: " + ex.getMessage());
//            System.out.println("Cannot divide a value by zero.");
//        }


        //Collections Sum Average Calculations =========================
//        SumAverage sumAverage=new SumAverage();
//        sumAverage.calculateSumAverageOfArrayListElements();


        //Multithreading ==========================
        Runnable r = new Runnable1();
        Thread t = new Thread(r);
        Runnable r2 = new Runnable2();
        Thread t2 = new Thread(r2);
        t.start();
        t2.start();
    }
}