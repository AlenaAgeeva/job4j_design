package ru.job4j.algo.stacks;

import java.util.Stack;

public class Brackets {

    public static boolean match(char a, char b) {
        return (a == '(' && b == ')')
                || (a == '{' && b == '}')
                || (a == '[' && b == ']');
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '[' || arr[i] == '(' || arr[i] == '{') {
                st.push(arr[i]);
            } else {
                if (st.isEmpty() || !match(st.peek(), arr[i])) {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
