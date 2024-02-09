package org.bajajpro;

public class Circle implements Shape{
    private final int  radius;
    private  double area;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void area() {
         area= 2*3.14*radius;
    }

    @Override
    public void displayInfo() {
        System.out.println("Radius of Circle is = "+radius);
        System.out.println("Area of Circle is = "+area);
    }
}
