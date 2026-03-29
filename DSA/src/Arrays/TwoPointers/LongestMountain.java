package Arrays.TwoPointers;

public class LongestMountain {
    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{2,1,4,7,3,2,5}));
    }

    public static int longestMountain(int[] arr) {
        int longestMountain = 0;
        int i = 1;
        while(i < arr.length - 1){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                int left = i - 1;
                int right = i + 1;
                while(left >= 0 && arr[left] < arr[left + 1]){
                    left--;
                }
                while(right < arr.length && arr[right] < arr[right - 1]){
                    right++;
                }
                longestMountain = Math.max(longestMountain, right - left - 1);
                i = right;
            }else{
                i++;
            }
        }
        return longestMountain;
    }
}
