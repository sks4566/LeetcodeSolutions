package Arrays.PrefixSum;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        System.out.println(new MaximumProductSubArray().maxProduct(new int[]{2,3,-2,4}));
        System.out.println(new MaximumProductSubArray().maxProduct(new int[]{-2,0,-1}));
    }
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++){

            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            result = Math.max(result, max);
        }

        return result;
    }
}
