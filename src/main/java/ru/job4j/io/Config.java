package ru.job4j.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final File path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final File path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader b = new BufferedReader(
                new FileReader(this.path))) {
            b.lines().filter(s -> !s.startsWith("#") && !s.isEmpty())
                    .peek(s -> {
                        if (!s.contains("=")
                                || s.endsWith("=")
                                || s.startsWith("=")) {
                            throw new IllegalArgumentException("Error");
                        }
                    })
                    .map(s -> s.split("=", 2))
                    .forEach(s -> values.put(s[0], s[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
