package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDiff {
    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[]{4,2,1,3}));

    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i=1; i<arr.length; i++){
            int diff = arr[i] - arr[i-1];
            if(diff < minDiff){
                minDiff = diff;
                ans.clear();
                ans.add(Arrays.asList(arr[i-1], arr[i]));
            }else if(diff == minDiff){
                ans.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return ans;
    }
}
