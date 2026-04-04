package Recursion.DivideAndConquer;

public class BinarySearch_704 {

    public static void main(String[] args) {
        System.out.println(new BinarySearch_704().search(new int[]{-1,0,3,5,9,12}, 9));
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        // base case
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            return binarySearch(nums, target, left, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, right);
        }
    }
}
