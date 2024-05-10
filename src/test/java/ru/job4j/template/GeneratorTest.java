package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
class GeneratorTest {

    @Test
    void whenTemplateDoesFitToMap() {
        Map<String, String> args = new HashMap<>();
        args.put("Petr Arsentev", "you");
        String template = "I am a ${name}, Who are ${subject}? ";
        String result = "I am a Petr Arsentev, Who are you? ";
        assertThat(new SentenceGenerator().produce(template, args)).isEqualTo(result);
    }

    @Test
    void whenMapHasNullAsKey() {
        Map<String, String> args = new HashMap<>();
        args.put(null, "you");
        String template = "I am a ${name}, Who are ${subject}? ";
        assertThatThrownBy(() -> new SentenceGenerator().produce(template, args))
                .isInstanceOf(Exception.class);
    }

    @Test
    void whenMapHasNullAsValue() {
        Map<String, String> args = new HashMap<>();
        args.put("Petr Arsentev", null);
        String template = "I am a ${name}, Who are ${subject}? ";
        assertThatThrownBy(() -> new SentenceGenerator().produce(template, args))
                .isInstanceOf(Exception.class);
    }

    @Test
    void whenTemplateHasMoreKeysThanMapElementsThenException() {
        Map<String, String> args = new HashMap<>();
        args.put("Petr Arsentev", "you");
        String template = "I am a ${name}, Who are ${subject}? Goodbye ${name}. ";
        String result = "I am a Petr Arsentev, Who are you? ? Goodbye Petr Arsentev. ";
        assertThatThrownBy(() -> new SentenceGenerator().produce(template, args))
                .isInstanceOf(Exception.class);
    }

    @Test
    void whenMapHasMoreThanOneElementThenException() {
        Map<String, String> args = new HashMap<>();
        args.put("Petr Arsentev", "you");
        args.put("Ivan Petrov", "you");
        String template = "I am a ${name}, Who are ${subject}? ";
        assertThatThrownBy(() -> new SentenceGenerator().produce(template, args))
                .isInstanceOf(Exception.class);
    }

    @Test
    void whenMapIsEmpty() {
        Map<String, String> args = new HashMap<>();
        String template = "I am a ${name}, Who are ${subject}? ";
        assertThatThrownBy(() -> new SentenceGenerator().produce(template, args))
                .isInstanceOf(Exception.class);
    }

    @Test
    void whenMapIsNull() {
        Map<String, String> args = null;
        String template = "I am a ${name}, Who are ${subject}? ";
        assertThatThrownBy(() -> new SentenceGenerator().produce(template, args))
                .isInstanceOf(Exception.class);
    }
}