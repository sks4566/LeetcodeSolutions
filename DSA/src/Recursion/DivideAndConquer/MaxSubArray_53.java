package Recursion.DivideAndConquer;

public class MaxSubArray_53 {
    public int maxSubArray(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private int divideAndConquer(int[] nums, int left, int right) {
        // Base Case: Only one element
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        // Recursively find the max in left and right halves
        int leftMax = divideAndConquer(nums, left, mid);
        int rightMax = divideAndConquer(nums, mid + 1, right);

        // Find the max that crosses the midpoint
        int crossMax = maxCrossingSum(nums, left, mid, right);

        // Return the best of the three
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftPart = Integer.MIN_VALUE;

        // Max sum from mid going left
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftPart) leftPart = sum;
        }

        sum = 0;
        int rightPart = Integer.MIN_VALUE;

        // Max sum from mid+1 going right
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightPart) rightPart = sum;
        }

        return leftPart + rightPart;
    }
}
