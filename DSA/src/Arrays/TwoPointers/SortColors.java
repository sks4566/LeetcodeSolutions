package Arrays.TwoPointers;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(sortColors(nums)));
    }

    public static  int[] sortColors(int[] nums) {
        int countRed = 0, countWhite = 0, countBlue = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 0){
                countRed++;
            }else if(nums[i] == 1){
                countWhite++;
            }else{
                countBlue++;
            }
        }
        for(int i = 0; i < countRed; i++){
            nums[i] = 0;
        }
        for(int i = countRed; i < countRed + countWhite; i++){
            nums[i] = 1;
        }
        for(int i = countRed + countWhite; i < nums.length -1; i++){
            nums[i] = 2;
        }

        return nums;

    }

    // Dutch National Flag Algorithm
    public void sortColorsDNF(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n-1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                swap(nums, mid, high);
                high--;
            }
        }
    }
    private void swap(int[] nums, int low, int high){
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
}
