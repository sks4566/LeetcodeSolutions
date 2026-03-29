package BinrarySearch.BasicBinarySearch;

public class MinimumLimitOfBall_1760 {
    public static void main(String[] args) {
        System.out.println(new MinimumLimitOfBall_1760().minimumSize(new int[]{9}, 2)); // 3
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;

        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canDistribute(nums, mid, maxOperations)) {
                right = mid; // try smaller max
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canDistribute(int[] nums, int maxBalls, int maxOperations) {
        int operations = 0;

        for (int num : nums) {
            operations += (num - 1) / maxBalls;

            if (operations > maxOperations) {
                return false;
            }
        }

        return true;
    }
}
