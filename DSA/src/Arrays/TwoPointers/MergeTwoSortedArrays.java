package Arrays.TwoPointers;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j  = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                i++;
            }else{
                for(int k = m-1; k >= i; k--){
                    nums1[k+1] = nums1[k];
                }
                nums1[i] = nums2[j];
                i++;
                j++;
                m++;
            }
        }
         while(j < n){
             nums1[i++] = nums2[j++];
         }
    }
}

