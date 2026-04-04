package BinrarySearch.AllocationProblems;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls_1552 {

    public static void main(String[] args) {
        System.out.println(new MagneticForceBetweenTwoBalls_1552().maxDistance(new int[]{1,2,3,4,7}, 3)); // 3
        System.out.println(new MagneticForceBetweenTwoBalls_1552().maxDistance(new int[]{5,4,3,2,1,1000000000}, 2)); // 999999999
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int left = 1;
        int right = position[position.length - 1] - position[0];
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canPlace(position, m, mid)) {
                answer = mid;     // valid
                left = mid + 1;   // try bigger distance
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canPlace(int[] position, int m, int dist) {
        int count = 1; // first ball placed
        int lastPlaced = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPlaced >= dist) {
                count++;
                lastPlaced = position[i];

                if (count == m) return true;
            }
        }

        return false;
    }
}
