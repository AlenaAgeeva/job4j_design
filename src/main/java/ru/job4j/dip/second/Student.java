package ru.job4j.dip.second;

import java.util.Objects;

public class Student {
    private String name;
    private String lastname;
    private int age;
    private String grade;

    public Student(String name, String lastname, int age, String grade) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student shcooler = (Student) o;
        return age == shcooler.age
                && name.equals(shcooler.name)
                && lastname.equals(shcooler.lastname)
                && grade.equals(shcooler.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, age, grade);
    }
}
