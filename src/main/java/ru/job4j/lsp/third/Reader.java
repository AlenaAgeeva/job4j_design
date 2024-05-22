package ru.job4j.lsp.third;

import java.util.List;

public class Reader {
    private String name;
    private String lastname;
    private int age;
    private List<Book> booksBorrowed;

    public Reader(String name, String lastname, int age, List<Book> booksBorrowed) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.booksBorrowed = booksBorrowed;
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

    public List<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(List<Book> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }

    class Book {
        private String author;
        private String name;
        private int number;

        public Book(String author, String name, int number) {
            this.author = author;
            this.name = name;
            this.number = number;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
}
