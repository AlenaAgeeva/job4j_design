package ru.job4j.serialization;

public class Pet {
    private final int paws;

    public Pet(int paws) {
        this.paws = paws;
    }

    @Override
    public String toString() {
        return "Pet{"
                + "paws=" + paws + '}';
    }
}
