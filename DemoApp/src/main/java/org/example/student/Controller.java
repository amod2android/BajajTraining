package org.example.student;

import java.util.ArrayList;

public interface Controller {
    void create();

    void display(ArrayList<Student> students);

    void delete();

    void getAll();

    void update();

    void searchByName();

}
