package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader b = new BufferedReader(
                new FileReader(this.path))) {
            b.lines().filter(s -> s.contains("=")
                            && !s.startsWith("#")
                            && !s.endsWith("="))
                    .map(s -> s.split("="))
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

    public static void main(String[] args) {
        Config config = new Config("./data/app.properties");
        config.load();
        System.out.println(config.value("hibernate.connection.password"));
    }

}
