package ru.job4j.gc.prof;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

public class RandomArray implements Data {
    public int[] array;
    private Random random;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm:ss:ms");

    public RandomArray(Random random) {
        this.random = random;
    }

    @Override
    public void insert(int elements) {
        array = Arrays.stream(new int[elements])
                .map(s -> s = random.nextInt(100))
                .toArray();
    }

    @Override
    public int[] getClone() {
        return array.clone();
    }

    public static String getTime() {
        return FORMATTER.format(LocalDateTime.now());
    }

    public static void main(String[] args) throws InterruptedException {
        RandomArray randomBubble = new RandomArray(new Random());
        RandomArray randomInsert = new RandomArray(new Random());
        RandomArray randomMerge = new RandomArray(new Random());
        System.out.println("Start of an array filling " + RandomArray.getTime());
        randomBubble.insert(250_000);
        randomInsert.insert(250_000);
        randomMerge.insert(250_000);
        System.out.println("End of an array filling " + RandomArray.getTime());
        System.out.println("Start of a Bubble sorting " + RandomArray.getTime());
        System.out.println(new BubbleSort().sort(randomBubble));
        System.out.println("End of a Bubble sorting " + RandomArray.getTime());
        System.out.println("Start of an Insert sorting " + RandomArray.getTime());
        System.out.println(new InsertSort().sort(randomInsert));
        System.out.println("End of a Insert sorting " + RandomArray.getTime());
        System.out.println("Start of a Merge sorting " + RandomArray.getTime());
        System.out.println(new MergeSort().sort(randomMerge));
        System.out.println("End of a Merge sorting " + RandomArray.getTime());
    }
}
