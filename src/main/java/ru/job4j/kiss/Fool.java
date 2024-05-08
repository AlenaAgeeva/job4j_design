package ru.job4j.kiss;

import java.util.Scanner;
import java.util.function.Predicate;

public class Fool {
    private static int startAt;

    public static Boolean check(Predicate<Integer> predicate, int number) {
        return predicate.test(number);
    }

    public static Boolean check(Predicate<String> predicate, String str) {
        return predicate.test(str);
    }

    public static String checkNumber(int num) {
        if (check(x -> x % 3 == 0 && x % 5 == 0, num)) {
            return "FizzBuzz";
        } else if (check(x -> x % 3 == 0, num)) {
            return "Fizz";
        } else if (check(x -> x % 5 == 0, num)) {
            return "Buzz";
        } else {
            return String.valueOf(num);
        }
    }

    public static String checkAnswer(String a, int num) {
        if (check((x) -> ("exit".equals(a)), a)) {
            System.exit(0);
        } else if (check(x -> x % 3 == 0 && x % 5 == 0, num)) {
            if (check((x) -> (!x.equals("FizzBuzz")), a)) {
                startAt = 0;
                return "Ошибка. Начинай снова.";
            }
        } else if (check(x -> x % 3 == 0, num)) {
            if (check((x) -> (!x.equals("Fizz")), a)) {
                startAt = 0;
                return "Ошибка. Начинай снова.";

            }
        } else if (check(x -> x % 5 == 0, num)) {
            if (check((x) -> (!x.equals("Buzz")), a)) {
                startAt = 0;
                return "Ошибка. Начинай снова.";

            }
        } else if (check((x) -> (!String.valueOf(num).equals(a)), a)) {
            startAt = 0;
            return "Ошибка. Начинай снова.";
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        startAt = 1;
        var io = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(checkNumber(startAt));
            startAt++;
            var answer = io.nextLine();
            System.out.println(checkAnswer(answer, startAt));
            startAt++;
        }
    }
}
