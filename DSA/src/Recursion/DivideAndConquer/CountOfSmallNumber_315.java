package Recursion.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallNumber_315 {
        int[] counts;

        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            counts = new int[n];

            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = nums[i]; // value
                arr[i][1] = i;       // original index
            }

            mergeSort(arr, 0, n - 1);

            List<Integer> result = new ArrayList<>();
            for (int count : counts) {
                result.add(count);
            }

            return result;
        }

        private void mergeSort(int[][] arr, int left, int right) {
            if (left >= right) return;

            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }

        private void merge(int[][] arr, int left, int mid, int right) {
            List<int[]> temp = new ArrayList<>();

            int i = left, j = mid + 1;
            int rightCount = 0;

            while (i <= mid && j <= right) {
                if (arr[i][0] <= arr[j][0]) {
                    counts[arr[i][1]] += rightCount;
                    temp.add(arr[i++]);
                } else {
                    rightCount++;
                    temp.add(arr[j++]);
                }
            }

            while (i <= mid) {
                counts[arr[i][1]] += rightCount;
                temp.add(arr[i++]);
            }

            while (j <= right) {
                temp.add(arr[j++]);
            }

            for (int k = 0; k < temp.size(); k++) {
                arr[left + k] = temp.get(k);
            }
        }
}
