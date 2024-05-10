package ru.job4j.kiss;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FoolTest {
    @Test
    void whenCheckNumber1then1() {
        int num = 1;
        String expected = "1";
        assertThat(Fool.getAnswer(num)).isEqualTo(expected);
    }

    @Test
    void whenCheckNumber3thenFizz() {
        int num = 3;
        String expected = "Fizz";
        assertThat(Fool.getAnswer(num)).isEqualTo(expected);
    }

    @Test
    void whenCheckNumber5thenBuzz() {
        int num = 5;
        String expected = "Buzz";
        assertThat(Fool.getAnswer(num)).isEqualTo(expected);
    }

    @Test
    void whenCheckNumber15thenFizzBuzz() {
        int num = 15;
        String expected = "FizzBuzz";
        assertThat(Fool.getAnswer(num)).isEqualTo(expected);
    }
}