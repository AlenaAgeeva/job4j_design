package ru.job4j.algo.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Intervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = new int[2];
            if (result.get(result.size() - 1)[1] >= intervals[i][0]) {
                temp[0] = Math.min(result.get(result.size() - 1)[0], intervals[i][0]);
                temp[1] = Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
                result.set(result.size() - 1, temp);
            } else {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
