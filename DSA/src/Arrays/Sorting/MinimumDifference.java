package Arrays.Sorting;

import java.util.Arrays;

public class MinimumDifference {
    public static void main(String[] args) {
        System.out.println(new MinimumDifference().minimumDifference(new int[]{90}, 1));
    }

    public int minimumDifference(int[] nums, int k) {
        if(k ==1){
            return 0;
        }
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i <= nums.length - k; i++){

            int diff = nums[i + k - 1] - nums[i];

            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}
