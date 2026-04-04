package BinrarySearch.AllocationProblems;

import java.util.Arrays;

public class AggressiveCows {

    /**
     Acceptance: 40%
     You are given an array of integers stalls where stalls[i] represents the position of the ith stall. You are also given an integer k which represents the number of cows. The task is to place the cows in the stalls such that the minimum distance between any two cows is as large as possible.

     Return the largest minimum distance possible between any two of the k cows placed in the stalls.

     Examples:
     Example 1:

     Input:
     stalls = [1, 2, 4, 8, 9], k = 3

     Output:
     3
     */

    public static void main(String[] args) {
        System.out.println(new AggressiveCows().aggressiveCows(new int[]{1, 2, 4, 8, 9}, 3)); // 3

    }

    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // critical step

        int left = 1;
        int right = stalls[stalls.length - 1] - stalls[0];
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canPlaceCows(stalls, k, mid)) {
                answer = mid;      // valid distance
                left = mid + 1;    // try bigger distance
            } else {
                right = mid - 1;   // reduce distance
            }
        }

        return answer;
    }

    private boolean canPlaceCows(int[] stalls, int k, int dist) {
        int cows = 1; // first cow at first stall
        int lastPlaced = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlaced >= dist) {
                cows++;
                lastPlaced = stalls[i];

                if (cows == k) return true;
            }
        }
        return false;
    }
}
