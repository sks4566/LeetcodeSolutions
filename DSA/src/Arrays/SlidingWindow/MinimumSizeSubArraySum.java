package Arrays.SlidingWindow;

public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubArraySum().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(new MinimumSizeSubArraySum().minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(new MinimumSizeSubArraySum().minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
        System.out.println(new MinimumSizeSubArraySum().minSubArrayLen(7, new int[]{8}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int miminalSubArrLength = Integer.MAX_VALUE;
        int n = nums.length;
        int left = 0;
        int right = 1;
        int sum = nums[0];
        if(sum >= target){
            return 1;
        }

        while(left < n-1 && right < n){
            if(nums[left] >= target || nums[right] >= target){
                return 1;
            }else{
                sum = sum + nums[right];
                if(sum >= target){
                    miminalSubArrLength = Math.min(miminalSubArrLength, (right - left) + 1);
                    left++;
                    right = left + 1;
                    sum = nums[left];
                }else{
                    right++;
                }

            }
        }
        return miminalSubArrLength == Integer.MAX_VALUE ? 0 : miminalSubArrLength;
    }

    public int minSubArrayLenBetter(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
