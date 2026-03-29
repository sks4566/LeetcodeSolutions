package Arrays.SlidingWindow;

public class LongestContinousIncresingSubArr {
    public static void main(String[] args) {
        System.out.println(new LongestContinousIncresingSubArr().findLengthOfLCIS(new int[]{1,3,5,4,7}));
    }

    public int findLengthOfLCIS(int[] nums) {
        int maxLength = 1;
        int currentLength = 1;

        for(int i = 1; i < nums.length; i++){

            if(nums[i] > nums[i-1]){
                currentLength++;
            } else {
                currentLength = 1;
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
