package Arrays.SlidingWindow;

public class MaximumAverageSubArray {
    public static void main(String[] args) {
        System.out.println(new MaximumAverageSubArray().findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
         System.out.println(new MaximumAverageSubArray().findMaxAverage(new int[]{5}, 1));
    }
    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;

        // Step 1: Calculate sum of first window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // Step 2: Slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i];      // add new element
            windowSum -= nums[i - k];  // remove old element

            maxSum = Math.max(maxSum, windowSum);
        }

        // Step 3: Return maximum average
        return (double) maxSum / k;
    }
}
