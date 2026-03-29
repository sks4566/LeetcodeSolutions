package Arrays.PrefixSum;

public class PivotIndex {
    public static void main(String[] args) {
        System.out.println(new PivotIndex().pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(new PivotIndex().pivotIndex(new int[]{1,2,3}));
         System.out.println(new PivotIndex().pivotIndex(new int[]{2,1,-1}));
    }
    public int pivotIndex(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}
