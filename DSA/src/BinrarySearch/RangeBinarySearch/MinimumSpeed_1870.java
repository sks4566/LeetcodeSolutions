package BinrarySearch.RangeBinarySearch;

public class MinimumSpeed_1870 {
    public static void main(String[] args) {
        System.out.println(new MinimumSpeed_1870().minSpeedOnTime(new int[]{1, 3, 2}, 6)); // 1
        System.out.println(new MinimumSpeed_1870().minSpeedOnTime(new int[]{1, 3, 2}, 2.7)); // 3
    }
    public int minSpeedOnTime(int[] dists, double hour) {
        int n = dists.length;

        if (hour <= n - 1) return -1;

        int left = 1;
        int right = 10_000_000; // safe upper bound based on constraints

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canReach(dists, mid, hour)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canReach(int[] dists, int speed, double hour) {
        double time = 0.0;

        // first n-1 trains → ceil
        for (int i = 0; i < dists.length - 1; i++) {
            time += (dists[i] + speed - 1) / speed; // ceil
        }

        // last train → exact division
        time += (double) dists[dists.length - 1] / speed;

        return time <= hour;
    }
}
