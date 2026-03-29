package Arrays.TwoPointers;

public class ShortestUnsortedSubArr {
    public static void main(String[] args) {
        int[] arr = {2,6,4,8,10,9,15};
        System.out.println(new ShortestUnsortedSubArr().findUnsortedSubarray(arr));
    }

    public int findUnsortedSubarray(int[] arr) {
        int n = arr.length;

        int low = 0;
        int high = n - 1;

        // Step 1: find first unsorted element from left
        while (low < n - 1 && arr[low] <= arr[low + 1]) {
            low++;
        }

        // If already sorted
        if (low == n - 1) return 0;

        // Step 2: find first unsorted element from right
        while (high > 0 && arr[high] >= arr[high - 1]) {
            high--;
        }

        // Step 3: find min and max in subarray
        int subarrayMin = Integer.MAX_VALUE;
        int subarrayMax = Integer.MIN_VALUE;

        for (int k = low; k <= high; k++) {
            subarrayMin = Math.min(subarrayMin, arr[k]);
            subarrayMax = Math.max(subarrayMax, arr[k]);
        }

        // Step 4: expand left boundary
        while (low > 0 && arr[low - 1] > subarrayMin) {
            low--;
        }

        // Step 5: expand right boundary
        while (high < n - 1 && arr[high + 1] < subarrayMax) {
            high++;
        }

        return high - low + 1;
    }
    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int left = -1, right = -1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > min) {
                left = i;
            } else {
                min = nums[i];
            }
        }

        return right == -1 ? 0 : right - left + 1;
    }
}
