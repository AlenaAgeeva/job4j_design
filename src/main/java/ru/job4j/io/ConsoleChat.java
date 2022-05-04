package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        try (BufferedReader b = new BufferedReader(new InputStreamReader(System.in))) {
            String userPhrase;
            List<String> botPh = readPhrases();
            List<String> log = new ArrayList<>();
            boolean canRead = true;
            while (!OUT.equals(userPhrase = b.readLine())) {
                String s = botPh.get(new Random().nextInt(botPh.size()));
                if (canRead) {
                    if (!STOP.equals(userPhrase)) {
                        log.add("User: " + userPhrase);
                        log.add("Bot: " + s);
                        System.out.println(s);
                        continue;
                    }
                    canRead = false;
                    log.add("User: " + userPhrase);
                } else {
                    if (!CONTINUE.equals(userPhrase)) {
                        log.add("User: " + userPhrase);
                        continue;
                    }
                    canRead = true;
                    log.add("User: " + userPhrase);
                    log.add("Bot: " + s);
                    System.out.println(s);
                }
            }
            saveLog(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readPhrases() {
        List<String> ph = new ArrayList<>();
        try (BufferedReader b = new BufferedReader(new FileReader(botAnswers))) {
            b.lines().forEach(ph::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ph;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter p = new PrintWriter(path)) {
            log.forEach(p::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/chatConsoleLog.txt", "./data/botAnswers.txt");
        cc.run();
    }
}
