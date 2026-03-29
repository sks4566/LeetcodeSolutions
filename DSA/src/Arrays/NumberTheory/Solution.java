package Arrays.NumberTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,3,3,5,6};
        removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> unionList = new ArrayList<>();
        int m = nums1.length;
        int n = nums1.length;
        int i = 0;
        int j = 0;
        while(i<m && j<n){
            if(nums1[i] <= nums2[j]){
                if(unionList.size() == 0 || unionList.getLast() != nums1[i]){
                    unionList.add(nums1[i]);
                }
                i++;
            }else{
                if(unionList.size() == 0 || unionList.getLast() != nums2[j]){
                unionList.add(nums2[j]);
            }
                j++;
            }
        }
        int[] ansArr = new int[unionList.size()];
        for(int k = 0; k < unionList.size(); k++){
            ansArr[i] = unionList.get(i);
        }
    return ansArr;
    }



    public static int removeDuplicates(int[] nums) {
        //[0,0,3,3,5,6]
        int j = 1;
        int count = 0;
        for(int i = 0; i< nums.length-1;i++){
            if(nums[i] != nums[j]){
                nums[i] = nums[j];
                nums[j] = 10000;
                count++;
            }
            j++;
        }
        return count;
    }

    public static void rotateArray(int[] nums, int k) {
        int effectiveRotations = k > nums.length ? k%nums.length : k;
        reverse(nums, 0, effectiveRotations-1);
        reverse(nums, effectiveRotations, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}