package ru.job4j.collection.list.map;

import java.util.*;
import java.util.stream.Stream;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User userOne = new User("Tom", 2, new GregorianCalendar(1986, 5, 11));
        User userTwo = new User("Tom", 2, new GregorianCalendar(1986, 5, 11));
        Map<User, Object> map = new HashMap<>();
        map.put(userOne, new Object());
        map.put(userTwo, new Object());
        Stream.of(map).forEach(System.out::println);
    }
}
