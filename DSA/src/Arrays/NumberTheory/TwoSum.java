package Arrays.NumberTheory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, -7, 6, -3};
        System.out.println(Arrays.toString(twoSum(nums,0)));

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int firstIndex = 0, secondIndex = 0;
        for(int i =0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                firstIndex = i;
                secondIndex = map.get(target - nums[i]);
                break;
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[]{Math.min(firstIndex, secondIndex), Math.max(firstIndex, secondIndex)};
    }
}
