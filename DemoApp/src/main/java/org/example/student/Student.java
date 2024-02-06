package org.example.student;

import org.example.User;

public class Student extends User {
    int rollNo;
    String subject;

    public Student(String name, int age, String city, int rollNo, String subject) {
        super(name, age, city);
        this.rollNo = rollNo;
        this.subject = subject;

    }

    @Override
    public String toString() {
        return "Student{" +
                "name,age,city='" + super.toString() + '\'' +
                ", rollNo=" + rollNo +
                ", subject='" + subject + '\'' +
                '}';
    }
}
