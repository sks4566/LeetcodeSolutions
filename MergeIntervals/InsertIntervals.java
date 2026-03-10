package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
    public static void main(String[] args) {
        System.out.println( new InsertIntervals().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}));
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // Step 1: Add intervals before newInterval
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        // Step 3: Add remaining intervals
        while(i < intervals.length){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
