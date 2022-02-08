package ru.job4j;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add(null);
//        list.add("first");
//        list.add("second");
//        list.add("third");
        System.out.println(list.stream().filter(x -> x != null).filter(x -> x.contains("i")).findFirst());
        //System.out.println(list.stream().filter(x->x.contains("i")).findFirst().map(String::length));
        System.out.println();


    }
}
