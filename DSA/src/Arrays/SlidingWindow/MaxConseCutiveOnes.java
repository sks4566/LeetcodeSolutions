package Arrays.SlidingWindow;

public class MaxConseCutiveOnes {
    public static void main(String[] args) {
        System.out.println(new MaxConseCutiveOnes().maxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
         System.out.println(new MaxConseCutiveOnes().maxConsecutiveOnes(new int[]{1,0,1,1,0,1}));

    }

    public int maxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0;
        int maxLength = 0;
        while(right < nums.length){
            if(nums[right] == 1){
                right++;
            } else {
                maxLength = Math.max(maxLength, right - left);
                right++;
                left = right;
            }
        }
        maxLength = Math.max(maxLength, right - left);
        return maxLength;
    }
}
