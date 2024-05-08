package ru.job4j.kiss;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void whenCheckNumber1then1() {
        int num = 1;
        String expected = "1";
        assertThat(Fool.checkNumber(num)).isEqualTo(expected);
    }

    @Test
    void whenCheckNumber3thenFizz() {
        int num = 3;
        String expected = "Fizz";
        assertThat(Fool.checkNumber(num)).isEqualTo(expected);
    }

    @Test
    void whenCheckNumber5thenBuzz() {
        int num = 5;
        String expected = "Buzz";
        assertThat(Fool.checkNumber(num)).isEqualTo(expected);
    }

    @Test
    void whenCheckNumber15thenFizzBuzz() {
        int num = 15;
        String expected = "FizzBuzz";
        assertThat(Fool.checkNumber(num)).isEqualTo(expected);
    }

    @Test
    void whenCheckNum1Answer1Then1() {
        int num = 1;
        String str = "1";
        String expected = "1";
        assertThat(Fool.checkAnswer(str, num)).isEqualTo(expected);
    }
    @Test
    void whenCheckNum97Answer1ThenAgain() {
        int num = 97;
        String str = "1";
        String expected = "Ошибка. Начинай снова.";
        assertThat(Fool.checkAnswer(str, num)).isEqualTo(expected);
    }

    @Test
    void whenCheckNum3AnswerFizzThenFizz() {
        int num = 3;
        String str = "Fizz";
        String expected = "Fizz";
        assertThat(Fool.checkAnswer(str, num)).isEqualTo(expected);
    }

    @Test
    void whenCheckNum3AnswerBuzzThenAgain() {
        int num = 3;
        String str = "Buzz";
        String expected = "Ошибка. Начинай снова.";
        assertThat(Fool.checkAnswer(str, num)).isEqualTo(expected);
    }

    @Test
    void whenCheckNum3Answer3ThenAgain() {
        int num = 3;
        String str = "3";
        String expected = "Ошибка. Начинай снова.";
        assertThat(Fool.checkAnswer(str, num)).isEqualTo(expected);
    }
    @Test
    void whenCheckNum5AnswerBuzzThenBuzz() {
        int num = 5;
        String str = "Buzz";
        String expected = "Buzz";
        assertThat(Fool.checkAnswer(str, num)).isEqualTo(expected);
    }

    @Test
    void whenCheckNum5AnswerFizzThenAgain() {
        int num = 5;
        String str = "Fizz";
        String expected = "Ошибка. Начинай снова.";
        assertThat(Fool.checkAnswer(str, num)).isEqualTo(expected);
    }
    @Test
    void whenCheckNum5Answer5ThenAgain() {
        int num = 5;
        String str = "5";
        String expected = "Ошибка. Начинай снова.";
        assertThat(Fool.checkAnswer(str, num)).isEqualTo(expected);
    }
    @Test
    void whenCheckNum15AnswerFizzBuzzThenFizzBuzz() {
        int num = 15;
        String str = "FizzBuzz";
        String expected = "FizzBuzz";
        assertThat(Fool.checkAnswer(str, num)).isEqualTo(expected);
    }

    @Test
    void whenCheckNum15AnswerFizzThenAgain() {
        int num = 15;
        String str = "Fizz";
        String expected = "Ошибка. Начинай снова.";
        assertThat(Fool.checkAnswer(str, num)).isEqualTo(expected);
    }
    @Test
    void whenCheckNum15AnswerBuzzThenAgain() {
        int num = 15;
        String str = "Buzz";
        String expected = "Ошибка. Начинай снова.";
        assertThat(Fool.checkAnswer(str, num)).isEqualTo(expected);
    }
    @Test
    void whenCheckNum15Answer15ThenAgain() {
        int num = 15;
        String str = "15";
        String expected = "Ошибка. Начинай снова.";
        assertThat(Fool.checkAnswer(str, num)).isEqualTo(expected);
    }
}