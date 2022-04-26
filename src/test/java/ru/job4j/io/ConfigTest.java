package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
        assertThat(config.value("hibernate.connection"), is(Matchers.nullValue()));
        assertThat(config.value("#CheckForComment"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithoutEmpty() {
        String path = "./data/pair_without_empty.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
        assertThat(config.value("hibernate.connection"), is(Matchers.nullValue()));
        assertThat(config.value("#CheckForComment"), is(Matchers.nullValue()));
    }

    @Test
    public void whenWithCommentAndEmpty() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("hibernate.connection.password"), is("password"));
        assertThat(config.value("hibernate.connection.url"), is("jdbc:postgresql://127.0.0.1:5432/trackstudio"));
        assertThat(config.value("# PostgreSQL"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithSeveralSymbols() {
        String path = "./data/pair_with_several_symbols.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("hibernate.connection.url"), is("jdbc:postgresql://127.0.0.1:5432/trackstudio=2"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNoSymbol() {
        String path = "./data/no_symbol.properties";
        Config config = new Config(path);
        config.load();

    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNoKey() {
        String path = "./data/pair_no_key.properties";
        Config config = new Config(path);
        config.load();

    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNoValue() {
        String path = "./data/pair_no_value.properties";
        Config config = new Config(path);
        config.load();

    }
}

