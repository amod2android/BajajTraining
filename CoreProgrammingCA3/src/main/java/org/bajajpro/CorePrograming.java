package org.bajajpro;

import java.util.Scanner;

public class CorePrograming {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

      /*  1. Assignment: Object-Oriented Basics
        Create a class named Car with attributes such as make, model, and year.
        Add a method to print the details of the car.
        Create an instance of the Car class and display its details.*/

        Car car=new Car("BMW","BMW X1","2020");
        System.out.println(car.details());
        Car car1=new Car("BMW","BMW X1","2095");
        System.out.println(car1.details());
        Car car2=new Car("BMW","BMW Z4","2090");
        System.out.println(car2.details());


       /* 2. Assignment: Inheritance
        Create a base class called Shape with methods area() and displayInfo().
                Create two subclasses, Circle and Rectangle, inheriting from Shape.
        Implement the area() method for both subclasses.
        Create instances of both subclasses and display their areas and other relevant information.*/

        //Area Of Rectangle ============================
        System.out.println("Enter Height");
        int height=scanner.nextInt();
        System.out.println("Enter Width");
        int width=scanner.nextInt();
        Rectangle rectangle = new Rectangle(height, width);
        rectangle.area();
        rectangle.displayInfo();

        //Area Of Circle ============================
        System.out.println("Enter Radius");
        int radius=scanner.nextInt();
        Circle circle = new Circle(radius);
        circle.area();
        circle.displayInfo();

        /*3. Assignment: Exception Handling
        Write a program that takes user input for two numbers and performs division.
        Handle the ArithmeticException for division by zero.
        Display an appropriate message for the user.*/

        System.out.println("Enter Numerator");
        int numerator=scanner.nextInt();
        System.out.println("Enter Denominator");
        int denominator=scanner.nextInt();
        try {
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.out.println("Cannot divide a value by zero.");
        }


        /*4. Assignment: Collections
        Create an ArrayList of integers.
        Write a method to find and display the sum and average of the elements.
        Add some elements to the list and invoke the method.*/


        SumAverage sumAverage=new SumAverage();
        sumAverage.calculateSumAverageOfArrayListElements();
    }
}
