package ru.job4j.dip.second;

import java.util.ArrayList;

public class School {
    private ArrayList<Student> students;

    public School() {
        this.students = new ArrayList<>();
    }

    public void addSchooler(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void removeSchooler(Student student) {
        students.removeIf(s -> students.contains(student));
    }
}
