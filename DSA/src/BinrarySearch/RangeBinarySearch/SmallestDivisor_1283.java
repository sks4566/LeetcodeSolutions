package BinrarySearch.RangeBinarySearch;

public class SmallestDivisor_1283 {
    public static void main(String[] args) {
        System.out.println(new SmallestDivisor_1283().smallestDivisor(new int[]{1,2,5,9}, 6)); // 5
        System.out.println(new SmallestDivisor_1283().smallestDivisor(new int[]{2,3,5,7,11}, 11)); // 3
        System.out.println(new SmallestDivisor_1283().smallestDivisor(new int[]{19}, 5)); // 4
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;

        // find max element (upper bound)
        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canDivide(nums, mid, threshold)) {
                right = mid;   // try smaller divisor
            } else {
                left = mid + 1; // need larger divisor
            }
        }

        return left;
    }

    private boolean canDivide(int[] nums, int divisor, int threshold) {
        int sum = 0;

        for (int num : nums) {
            // efficient ceil division
            sum += (num + divisor - 1) / divisor;

            // early exit optimization
            if (sum > threshold) return false;
        }

        return sum <= threshold;
    }
}
