package BinrarySearch.RangeBinarySearch;

public class MinimumDaysToMakeBouquet_1482 {
    public static void main(String[] args) {
        System.out.println(new MinimumDaysToMakeBouquet_1482().minDays(new int[]{1, 10, 3, 10, 2}, 3, 1)); // 3
        System.out.println(new MinimumDaysToMakeBouquet_1482().minDays(new int[]{1, 10, 3, 10, 2}, 3, 2)); // -1
    }
    public int minDays(int[] bloomDay, int m, int k) {
        // Edge case: not enough flowers
        if ((long)m * k > bloomDay.length) return -1;

        int left = Integer.MAX_VALUE;
        int right = 0;

        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canMakeBouquet(bloomDay, mid, m, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canMakeBouquet(int[] bloomDay, int currentDay, int m, int k) {
        int bouquetCount = 0;
        int adjacentFlowerPicked = 0;

        for (int day : bloomDay) {
            if (day <= currentDay) {
                adjacentFlowerPicked++;

                if (adjacentFlowerPicked == k) {
                    bouquetCount++;
                    adjacentFlowerPicked = 0;
                }
            } else {
                // 🔥 reset when adjacency breaks
                adjacentFlowerPicked = 0;
            }

            // optional optimization
            if (bouquetCount >= m) return true;
        }

        return bouquetCount >= m;
    }
}
