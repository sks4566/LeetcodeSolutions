package Sorting;

import java.util.Arrays;

public class MaximumProduct {
    public static void main(String[] args) {
        System.out.println(new MaximumProduct().maximumProduct(new int[]{-1,-2,-3, -4}));
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int maxProduct = nums[0] * nums[1] * nums[nums.length - 1];
        for(int i = 0; i < nums.length - 2; i++){
            int product = nums[i] * nums[i+1] * nums[i+2];
            maxProduct = Math.max(maxProduct, product);
        }
        return maxProduct;
    }

    // This is the optimal solution, we only need to check the product of the three largest numbers and the product of the two smallest numbers and the largest number
    public int maximumProduct2(int[] nums) {
        Arrays.sort(nums);
        return Integer.max((nums[0]*nums[1]*nums[nums.length-1]), (nums[nums.length-1]*nums[nums.length-2]*nums [nums.length-3]));
    }
}
