package BinrarySearch.RangeBinarySearch;

public class MaximumValueAtGivenIndex_1802 {
    public static void main(String[] args) {
        System.out.println(new MaximumValueAtGivenIndex_1802().maxValue(4, 2, 6)); // 2
        System.out.println(new MaximumValueAtGivenIndex_1802().maxValue(6, 1, 10)); // 3
    }
    public int maxValue(int n, int index, int maxSum) {
        int left = 1;
        int right = maxSum;

        while (left < right) {
            int mid = left + (right - left + 1) / 2; // bias to right

            if (isValid(n, index, maxSum, mid)) {
                left = mid;  // try bigger value
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean isValid(int n, int index, int maxSum, int x) {
        long leftSum = calculateSum(x, index);                 // left side
        long rightSum = calculateSum(x, n - index - 1);        // right side

        long total = leftSum + x + rightSum;

        return total <= maxSum;
    }

    private long calculateSum(int x, int len) {
        if (x > len) {
            // full decreasing sequence
            long first = x - 1;
            long last = x - len;
            return (first + last) * len / 2;
        } else {
            // hits 1, then fills with 1s
            long decreasing = (long)(x - 1) * x / 2;
            long ones = len - (x - 1);
            return decreasing + ones;
        }
    }

}
