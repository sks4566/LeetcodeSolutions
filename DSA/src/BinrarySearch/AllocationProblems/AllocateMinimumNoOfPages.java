package BinrarySearch.AllocationProblems;

public class AllocateMinimumNoOfPages {
    /**
     * Given an array of integers nums where nums[i] represents the number of pages in the ith book, and an integer k representing the number of students, allocate books to students so that the maximum number of pages assigned to a student is minimized. Each student must be assigned at least one book, and books must be allocated in contiguous order.
     *
     * Return the minimum possible value of the maximum number of pages assigned to a student.
     *
     * If it is not possible to allocate books to all students, return -1.
     */

    public static void main(String[] args) {
        System.out.println(new AllocateMinimumNoOfPages().allocateMinimumNumberOfPages(new int[]{10, 20, 30, 40}, 2)); // 60
        System.out.println(new AllocateMinimumNoOfPages().allocateMinimumNumberOfPages(new int[]{10, 20, 30, 40}, 3)); // 40
        System.out.println(new AllocateMinimumNoOfPages().allocateMinimumNumberOfPages(new int[]{10, 20, 30, 40}, 4)); // 40
        System.out.println(new AllocateMinimumNoOfPages().allocateMinimumNumberOfPages(new int[]{10, 20, 30, 40}, 5)); // -1
    }

    public int allocateMinimumNumberOfPages(int[] nums, int k) {
        int left = 0;
        int right = 0;

        // define search space
        for (int num : nums) {
            left = Math.max(left, num); // minimum possible max pages
            right += num;               // maximum possible max pages
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canAllocate(nums, mid, k)) {
                right = mid;  // try smaller max pages
            } else {
                left = mid + 1; // need larger max pages
            }
        }

        return left;

    }


    private boolean canAllocate(int[] nums, int maxAllowedPages, int k) {
        int students = 1; // at least one student
        int currentPages = 0;

        for (int num : nums) {
            if (currentPages + num > maxAllowedPages) {
                students++;        // start new student
                currentPages = num;   // reset pages

                if (students > k) return false;
            } else {
                currentPages += num;
            }
        }

        return true;
    }
}
