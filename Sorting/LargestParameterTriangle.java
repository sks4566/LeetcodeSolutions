package Sorting;

import java.util.Arrays;

public class LargestParameterTriangle {
    public static void main(String[] args) {

    }

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int maxPerimeter = 0;
        for(int i = 0; i < nums.length - 2; i++){
            if(checkTriangle(nums[i], nums[i+1], nums[i+2])){
                maxPerimeter = Math.max(nums[i] + nums[i+1] + nums[i+2], maxPerimeter);;
            }
        }
        return maxPerimeter;
    }

    // This is the optimal solution, we only need to check the three largest numbers, if they form a triangle, then we return their perimeter, otherwise we check the next three largest numbers and so on until we find a valid triangle or we run out of numbers
    public int largestPerimeterCheckFromBack(int[] nums) {

        Arrays.sort(nums);

        for(int i = nums.length - 1; i >= 2; i--){

            if(nums[i-1] + nums[i-2] > nums[i]){
                return nums[i] + nums[i-1] + nums[i-2];
            }
        }

        return 0;
    }

    private Boolean checkTriangle(int a , int b, int c){
        return (a + b) > c && (b + c) > a && (a + c) > b;
    }
}
