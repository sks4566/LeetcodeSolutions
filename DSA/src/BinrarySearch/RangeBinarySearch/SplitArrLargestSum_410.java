package BinrarySearch.RangeBinarySearch;

public class SplitArrLargestSum_410 {
    public static void main(String[] args) {
        System.out.println(new SplitArrLargestSum_410().splitArray(new int[]{7,2,5,10,8}, 2)); // 18
        System.out.println(new SplitArrLargestSum_410().splitArray(new int[]{1,2,3,4,5}, 2)); // 9
        System.out.println(new SplitArrLargestSum_410().splitArray(new int[]{1,4,4}, 3)); // 4
    }
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;

        // define search space
        for (int num : nums) {
            left = Math.max(left, num); // minimum possible max sum
            right += num;               // maximum possible max sum
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, mid, k)) {
                right = mid;  // try smaller max sum
            } else {
                left = mid + 1; // need larger max sum
            }
        }

        return left;
    }

    private boolean canSplit(int[] nums, int maxAllowedSum, int k) {
        int subarrays = 1; // at least one subarray
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxAllowedSum) {
                subarrays++;        // start new subarray
                currentSum = num;   // reset sum

                if (subarrays > k) return false;
            } else {
                currentSum += num;
            }
        }

        return true;
    }
}
