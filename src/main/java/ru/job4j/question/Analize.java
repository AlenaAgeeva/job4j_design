package ru.job4j.question;

import java.util.*;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, String> mapCurrent = new HashMap<>();
        Map<Integer, String> mapPrevious = new HashMap<>();
        previous.forEach(p -> mapPrevious.put(p.getId(), p.getName()));
        current.forEach(c -> mapCurrent.put(c.getId(), c.getName()));
        int added = (int) mapCurrent.keySet()
                .stream()
                .filter(c -> !mapPrevious.containsKey(c))
                .count();
        int removed = (int) mapPrevious.keySet()
                .stream()
                .filter(p -> !mapCurrent.containsKey(p))
                .count();
        int changed = (int) mapPrevious.entrySet()
                .stream()
                .filter(p -> mapCurrent.containsKey(p.getKey())
                        && !mapCurrent.containsValue(p.getValue()))
                .count();
        return new Info(added, changed, removed);
    }
}
