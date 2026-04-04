package Recursion.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class CountRangeSum_327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return mergeSort(prefix, 0, prefix.length - 1, lower, upper);
    }

    private int mergeSort(long[] prefix, int left, int right, int lower, int upper) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;

        int count = mergeSort(prefix, left, mid, lower, upper)
                + mergeSort(prefix, mid + 1, right, lower, upper);

        count += countPairs(prefix, left, mid, right, lower, upper);

        merge(prefix, left, mid, right);

        return count;
    }

    private int countPairs(long[] prefix, int left, int mid, int right, int lower, int upper) {
        int count = 0;

        int start = mid + 1;
        int end = mid + 1;

        for (int i = left; i <= mid; i++) {

            while (start <= right && prefix[start] - prefix[i] < lower) {
                start++;
            }

            while (end <= right && prefix[end] - prefix[i] <= upper) {
                end++;
            }

            count += (end - start);
        }

        return count;
    }

    private void merge(long[] prefix, int left, int mid, int right) {
        List<Long> temp = new ArrayList<>();

        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (prefix[i] <= prefix[j]) {
                temp.add(prefix[i++]);
            } else {
                temp.add(prefix[j++]);
            }
        }

        while (i <= mid) temp.add(prefix[i++]);
        while (j <= right) temp.add(prefix[j++]);

        for (int k = 0; k < temp.size(); k++) {
            prefix[left + k] = temp.get(k);
        }
    }
}
