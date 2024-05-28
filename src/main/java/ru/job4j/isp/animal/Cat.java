package ru.job4j.isp.animal;

public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("Cat is eating.");
    }

    @Override
    public void hunt() {
        System.out.println("Cat is hunting.");
    }

    @Override
    public void sleep() {
        System.out.println("Cat is sleeping.");
    }
}
