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
    private static String userPhrase;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        try (BufferedReader b = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> botPh = readPhrases();
            List<String> log = new ArrayList<>();
            boolean canRead = true;
            while (!OUT.equals(updateUserPhrase(b))) {
                String s = botPh.get(new Random().nextInt(botPh.size()));
                if (canRead) {
                    if (STOP.equals(userPhrase)) {
                        canRead = false;
                        log.add("User: " + userPhrase);
                        continue;
                    }
                    log.add("User: " + userPhrase);
                    log.add("Bot: " + s);
                    System.out.println(s);
                } else {
                    if (CONTINUE.equals(userPhrase)) {
                        canRead = true;
                        log.add("User: " + userPhrase);
                        log.add("Bot: " + s);
                        System.out.println(s);
                        continue;
                    }
                    log.add("User: " + userPhrase);
                }
            }
            log.add(OUT);
            saveLog(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String updateUserPhrase(BufferedReader br) throws IOException {
        userPhrase = br.readLine();
        return userPhrase;
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
