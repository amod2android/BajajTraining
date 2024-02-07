package org.bajajpro;

import java.util.ArrayList;
import java.util.Scanner;

public class SumAverage {

    public void calculateSumAverageOfArrayListElements(){
        Scanner scanner=new Scanner(System.in);
        ArrayList<Integer> intList=new ArrayList<>();
        System.out.println("Enter how many numbers you want to add in array list");
        int count=scanner.nextInt();
        System.out.println("Enter "+count+" Numbers");
        for(int i=0;i<count;i++){
            intList.add(scanner.nextInt());
        }
        double sum=0;
        for (Integer integer : intList) {
            sum = sum + integer;
        }
        System.out.println("Sum of the elements ="+sum);
        System.out.println("Average of the elements ="+(sum/count));
    }
}
