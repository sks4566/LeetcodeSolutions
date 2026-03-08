package TwoPointers;

import java.util.Arrays;

public class SquareOfSortedArray {

    public static void main(String[] args) {
        int [] nums = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0, j = n-1, k = n-1;
        while(i < j){
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                ans[k--] = nums[i] * nums[i];
                i++;
            }else{
                ans[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return ans;
    }
}
