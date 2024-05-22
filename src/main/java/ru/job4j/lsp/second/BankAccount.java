package ru.job4j.lsp.second;

public class BankAccount {
    private String name;
    private String lastname;
    private int age;
    private int number;
    private double deposit;
    private double creditScore;

    public BankAccount(String name, String lastname, int age, int number, double deposit, double sreditScore) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.number = number;
        this.deposit = deposit;
        this.creditScore = sreditScore;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(double creditScore) {
        this.creditScore = creditScore;
    }
}
