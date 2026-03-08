package Sorting;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(new LargestNumber().smallestNumber(new int[]{3,30,34,5,9}));
    }

    public String largestNumber(int[] nums) {

        String[] arr = new String[nums.length];

        for(int i=0;i<nums.length;i++){
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));

        if(arr[0].equals("0"))
            return "0";

        StringBuilder result = new StringBuilder();

        for(String s : arr)
            result.append(s);

        return result.toString();
    }

    public String smallestNumber(int[] nums) {

        String[] arr = new String[nums.length];

        for(int i = 0; i < nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a,b) -> (a+b).compareTo(b+a));

        StringBuilder result = new StringBuilder();

        for(String s : arr){
            result.append(s);
        }

        return result.toString();
    }
}
