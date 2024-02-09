package org.bajajpro;

public class Rectangle implements Shape{

    private int  height;
    private int  width;
    private double area;

    public Rectangle(int height,int width) {
        this.height=height;
        this.width=width;
    }

    @Override
    public void displayInfo() {
        System.out.println("Height of Rectangle is = "+height);
        System.out.println("Width of Rectangle is = "+width);
        System.out.println("Area of Rectangle is = "+area);
    }

    @Override
    public void area() {
         area= height*width;
    }
}
