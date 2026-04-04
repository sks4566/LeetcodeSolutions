package BinrarySearch.AllocationProblems;

public class MaximumCandiesAllocated_2226 {
    public static void main(String[] args) {
        System.out.println(new MaximumCandiesAllocated_2226().maximumCandies(new int[]{5,8,6}, 3)); // 5
        System.out.println(new MaximumCandiesAllocated_2226().maximumCandies(new int[]{2,5}, 11)); // 0
    }
    public int maximumCandies(int[] candies, long k) {
        int left = 1;
        int right = 0;

        // find max pile (upper bound)
        for (int candy : candies) {
            right = Math.max(right, candy);
        }

        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2; // candies per child

            if (canDistribute(candies, mid, k)) {
                answer = mid;     // valid
                left = mid + 1;   // try bigger value
            } else {
                right = mid - 1;  // reduce
            }
        }

        return answer;
    }

    private boolean canDistribute(int[] candies, int perChild, long k) {
        long count = 0;

        for (int candy : candies) {
            count += candy / perChild; // how many children this pile can serve

            if (count >= k) return true; // early exit
        }

        return false;
    }
}
