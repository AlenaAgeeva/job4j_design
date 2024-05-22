package ru.job4j.lsp.first;

import java.util.Calendar;

public class Account {
    private String name;
    private String lastname;
    private int accountNumber;
    private double points;
    private Calendar registrationDate;

    public Account(String name, String lastname, int account, double points, Calendar registrationDate) {
        this.name = name;
        this.lastname = lastname;
        this.accountNumber = account;
        this.points = points;
        this.registrationDate = registrationDate;
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

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }
}
