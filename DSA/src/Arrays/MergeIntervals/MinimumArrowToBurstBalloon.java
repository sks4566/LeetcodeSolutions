package Arrays.MergeIntervals;

import java.util.Arrays;

public class MinimumArrowToBurstBalloon {
    public static void main(String[] args) {
        System.out.println( new MinimumArrowToBurstBalloon().findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));

    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points , (a, b) -> Integer.compare(a[1], b[1]));
        int arrow = 1;
        int currentArrowPosition = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > currentArrowPosition) {
                arrow++;
                currentArrowPosition = points[i][1];
            }
        }
        return arrow;
    }
}
