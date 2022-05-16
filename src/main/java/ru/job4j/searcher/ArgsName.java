package ru.job4j.searcher;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (values.get(key) == null) {
            throw new IllegalArgumentException("Does not exist");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        Arrays.stream(args)
                .peek(s -> {
                    if (!s.startsWith("-")
                            || !s.contains("=")) {
                        throw new IllegalArgumentException("Not correct request");
                    }
                })
                .map(s -> s.split("=", 2))
                .peek(s -> {
                    if (s[0].isEmpty() || s[1].isEmpty()) {
                        throw new IllegalArgumentException("Key or value are null");
                    }
                })
                .forEach(s -> values.put(s[0].substring(1), s[1]));
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Do not have arguments");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}
