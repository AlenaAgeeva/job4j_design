package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {
    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    @Test
    public void whenTwoStrings() throws IOException {
        File source = temp.newFile("log.txt");
        File target = temp.newFile("target.txt");
        try (PrintWriter p = new PrintWriter(source)) {
            p.println("200 10:56:01");
            p.println("500 10:57:01");
            p.println("400 10:58:01");
            p.println("200 10:59:01");
            p.println("200 11:02:02");
            p.println("200 11:56:01");
            p.println("500 11:57:01");
            p.println("400 11:58:01");
            p.println("500 11:59:01");
            p.println("400 12:01:02");
            p.println("200 12:02:02");
        }
        new Analizy().unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        BufferedReader b = new BufferedReader(new FileReader(target));
        assertThat(b.readLine(), is("10:57:01;10:59:01;"));
        assertThat(b.readLine(), is("11:57:01;12:02:02;"));
    }
    @Test
    public void whenNoStrings() throws IOException {
        File source = temp.newFile("log.txt");
        File target = temp.newFile("target.txt");
        try (PrintWriter p = new PrintWriter(source)) {
            p.println("300 10:56:01");
            p.println("200 10:57:01");
            p.println("300 10:58:01");
            p.println("200 10:59:01");
        }
        new Analizy().unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        BufferedReader b = new BufferedReader(new FileReader(target));
        assertNull(b.readLine());
    }
    @Test
    public void whenNoStringsSecond() throws IOException {
        File source = temp.newFile("log.txt");
        File target = temp.newFile("target.txt");
        try (PrintWriter p = new PrintWriter(source)) {
            p.println("400 10:56:01");
            p.println("500 10:57:01");
            p.println("400 10:58:01");
            p.println("300 10:59:01");
        }
        new Analizy().unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        BufferedReader b = new BufferedReader(new FileReader(target));
        assertNull(b.readLine());
    }
}