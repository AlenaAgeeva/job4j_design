package ru.job4j.food.model;

import java.util.Calendar;

public class Fish extends Food {
    public Fish(String name, Calendar expiryDate, Calendar createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
