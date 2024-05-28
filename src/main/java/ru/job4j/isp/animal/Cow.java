package ru.job4j.isp.animal;

public class Cow implements Animal {
    @Override
    public void eat() {
        System.out.println("Cow is eating.");
    }

    @Override
    public void hunt() {
        try {
            throw new Exception("Cow cannot hunting.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sleep() {
        System.out.println("Cow is eating.");
    }
}
