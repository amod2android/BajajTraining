package org.example.student;

import java.util.ArrayList;

public interface Controller {
    public void create();
    public void display(ArrayList<Student> students);
    void delete();

    void getAll();
    void update();

}
