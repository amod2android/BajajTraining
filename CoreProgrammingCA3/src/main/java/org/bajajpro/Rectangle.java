package org.bajajpro;

public class Rectangle extends Shape{

    private int  height;
    private int  width;

    public Rectangle(int height,int width) {
        this.height=height;
        this.width=width;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(toString());
    }

    @Override
    public void area() {
        super.area();
        int area= height*width;
        System.out.println("Area of Rectangle is = "+area);

    }

    @Override
    public String toString() {
        return "Rectangle \n" +
                "height=" + height +
                ", \nwidth=" + width;
    }
}
