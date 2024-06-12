package ru.job4j.dip.first;

public class Book {
    private ConsolePrinter consolePrinter;
    private String text;

    public Book(ConsolePrinter consolePrinter, String text) {
        this.consolePrinter = consolePrinter;
        this.text = text;
    }

    public ConsolePrinter getConsolePrinter() {
        return consolePrinter;
    }

    public void setConsolePrinter(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void print() {
        consolePrinter.print(text);
    }
}
