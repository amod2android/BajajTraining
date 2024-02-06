package org.example.student;

import org.example.validators.NameValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController implements Controller{

    Scanner scanner= new Scanner(System.in);
    NameValidator nameValidator=new NameValidator();

    ArrayList<Student> students=new ArrayList<>();


    @Override
    public void create() {
        System.out.println("Enter Name age city,rollNo,subject respectively ");
        String name =scanner.next();
        int age=scanner.nextInt();
        String city =scanner.next();
        int rollNo =scanner.nextInt() ;
        String subject =scanner.next();

        if (nameValidator.validate(name)){
            Student student=new Student(name,age,city,rollNo,subject);
            students.add(student);
        }
    }

    @Override
    public void display() {
        students.forEach((student -> {
            System.out.println(student);
        }));


    }
}
