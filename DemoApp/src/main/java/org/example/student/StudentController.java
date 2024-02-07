package org.example.student;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentController implements Controller{
    Scanner scanner = new Scanner(System.in);
    StudentGateway studentGateway;
    public StudentController(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }
    @Override
    public void create() {
        System.out.println("enter name, age,rollno, city, subject, gender res");
        String name = scanner.next();
        int age = scanner.nextInt();
        int rollno = scanner.nextInt();
        String city = scanner.next();
        String subject = scanner.next();
        String gender = scanner.next();

        Student student = new Student(name, age, city, rollno, subject, gender);

        if (studentGateway.create(student) == 1) {
            System.out.println("Student Created");
        } else {
            System.out.println("Some problem");
        }
    }

    @Override
    public void getAll() {
        ArrayList<Student> students=studentGateway.get();
       this.display(students);
    }

    @Override
    public void update() {
        ArrayList<Student> students=studentGateway.get();
        this.display(students);
        System.out.println("Enter srl no and Name you want to update");
        int srl=scanner.nextInt();
        String name=scanner.next();
        Student student=students.get(srl-1);
        studentGateway.updateStudent(student.getId(),name);
    }

    @Override
    public void display(ArrayList<Student> students) {
        System.out.println(studentGateway.get());
        AtomicInteger counter= new AtomicInteger(1);
        students.forEach(student -> {
            System.out.println(counter+" "+student.getName()+" "+student.getRollNo()+" "+student.getCity());
            counter.getAndIncrement();
        });
    }

    @Override
    public void delete() {
        ArrayList<Student> students=studentGateway.get();
        this.display(students);
        System.out.println("Choose Serial No To delete");
        int srl=scanner.nextInt();
        Student student=students.get(srl-1);

        if(studentGateway.delete(student.getId())==1)
        {
            System.out.println("Student Deleted");
        }
        else {
            System.out.println("Some Problem");
        }
    }
}
