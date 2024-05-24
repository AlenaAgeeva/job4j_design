package ru.job4j.food.model;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Pastry extends Food {
    public Pastry(String name, Calendar expiryDate, Calendar createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
