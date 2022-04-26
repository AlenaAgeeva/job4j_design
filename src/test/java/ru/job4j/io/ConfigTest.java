package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {
    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    @Test
    public void whenPairWithoutComment() throws IOException {
        File source = temp.newFile("pair_without_comment.properties");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("");
            out.println("hibernate.connection.username=postgres");
            out.println("hibernate.connection.password=password");
        }
        Config config = new Config(source);
        config.load();
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
        assertThat(config.value("hibernate.connection"), is(Matchers.nullValue()));
        assertThat(config.value("#CheckForComment"), is(Matchers.nullValue()));
        assertThat(config.value(""), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithoutEmpty() throws IOException {
        File source = temp.newFile("pair_without_empty.properties");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect");
        }
        Config config = new Config(source);
        config.load();
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value(""), is(Matchers.nullValue()));
    }

    @Test
    public void whenWithCommentAndEmpty() throws IOException {
        File source = temp.newFile("app.properties");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("# PostgreSQL");
            out.println("");
            out.println("hibernate.connection.url=jdbc:postgresql://127.0.0.1:5432/trackstudio");
        }
        Config config = new Config(source);
        config.load();
        assertThat(config.value("hibernate.connection.url"), is("jdbc:postgresql://127.0.0.1:5432/trackstudio"));
        assertThat(config.value("# PostgreSQL"), is(Matchers.nullValue()));
        assertThat(config.value(""), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithSeveralSymbols() throws IOException {
        File source = temp.newFile("pair_with_several_symbols.properties");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect");
            out.println("hibernate.connection.url=jdbc:postgresql://127.0.0.1:5432/trackstudio=2");
        }
        Config config = new Config(source);
        config.load();
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("hibernate.connection.url"), is("jdbc:postgresql://127.0.0.1:5432/trackstudio=2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNoSymbol() throws IOException {
        File source = temp.newFile("no_symbol.properties");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("hibernate.dialect.org.hibernate.dialect.PostgreSQLDialect");
        }
        Config config = new Config(source);
        config.load();

    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNoKey() throws IOException {
        File source = temp.newFile("pair_no_key.properties");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect");
            out.println("=jdbc:postgresql://127.0.0.1:5432/trackstudio");
        }
        Config config = new Config(source);
        config.load();

    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNoValue() throws IOException {
        File source = temp.newFile("pair_no_value.properties");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect");
            out.println("hibernate.connection.url=");
        }
        Config config = new Config(source);
        config.load();
    }
}

