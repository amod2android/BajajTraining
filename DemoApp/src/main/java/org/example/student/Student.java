package org.example.student;

public class Student {
    private int id;

    public int getId() {
        return id;
    }

    public Student() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(int id, String name, int age, String city, int rollNo, String subject, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.rollNo = rollNo;
        this.subject = subject;
        this.gender = gender;
    }

    private String name;
    private int age;
    private String city;
    private int rollNo;
    private String subject;
    private String gender;

    public Student(String name, int age, String city, int rollNo, String subject, String gender) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.rollNo = rollNo;
        this.subject = subject;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", rollNo=" + rollNo +
                ", subject='" + subject + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
