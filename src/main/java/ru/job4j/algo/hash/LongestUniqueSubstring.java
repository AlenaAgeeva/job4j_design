package ru.job4j.algo.hash;


import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String str) {
        Set<String> set = new TreeSet<>(Comparator.reverseOrder());
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (!result.contains(String.valueOf(str.charAt(i)))) {
                result = result + str.charAt(i);
                set.add(result);
            } else {
                result = String.valueOf(str.charAt(i));
            }
        }
        return str.isBlank() ? str : set.stream().findFirst().get();
    }

    public static void main(String[] args) {
        System.out.println(LongestUniqueSubstring.longestUniqueSubstring("abcbcde"));
        long usedBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(usedBytes);
    }
}
