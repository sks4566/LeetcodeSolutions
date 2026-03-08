package TwoPointers;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int uniquesElements = 1;
        int i = 0;
        int j = 1;
        while(i < j && j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            }else{
                uniquesElements++;
                nums[i+1] = nums[j];
                i++;
                j++;
            }
        }
        return uniquesElements;
    }

    public static int removeDuplicates2(int[] nums) {
        int uniquesElements = 1;
        int currebtElementCount = 1;
        int i = 0;
        int j = 1;
        while(i < j && j < nums.length){
            if(nums[i] == nums[j] && currebtElementCount < 2){
                currebtElementCount++;
                uniquesElements++;
                j++;
                i++;
            }else{
                uniquesElements++;
                currebtElementCount = 1;
                nums[i+1] = nums[j];
                i++;
                j++;
            }
        }
        return uniquesElements;
    }


}
