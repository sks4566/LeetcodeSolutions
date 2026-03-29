package Arrays.NumberTheory;

import java.util.ArrayList;
import java.util.List;

public class Union2Arr {
    public static void main(String[] args) {
       int[] ans = new int[]{-3, 4, 5, 1, -30, -10};
       System.out.println(leaders(ans));
    }

    public static ArrayList<Integer> leaders(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ansList = new ArrayList();
        ansList.add(nums[n -1]);
        int leader = nums[n-1];
        for(int j = n-2; j >=0; j--){
            if(nums[j] > leader){
                ansList.add(0,nums[j]);
                leader = nums[j];
            }

        }
      return ansList;
    }



    public static int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> unionList = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;

        while(i < m && j < n){
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

        while(j < n){
            if(unionList.size() == 0 || unionList.getLast() != nums2[j]){
                unionList.add(nums2[j]);
            }
            j++;
        }

        while(i < m){
            if(unionList.size() == 0 || unionList.getLast() != nums1[i]){
                unionList.add(nums1[i]);
            }
            i++;
        }
        int[] ans = new int[unionList.size()];
        for(int k = 0; k < unionList.size(); k++){
            ans[k] = unionList.get(k);
        }

        return ans;
    }
}
