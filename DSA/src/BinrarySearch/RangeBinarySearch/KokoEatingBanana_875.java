package BinrarySearch.RangeBinarySearch;

public class KokoEatingBanana_875 {
    public static void main(String[] args) {
        System.out.println(new KokoEatingBanana_875().minEatingSpeed(new int[]{3, 6, 7, 11}, 8)); // 4
        System.out.println(new KokoEatingBanana_875().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5)); // 30
        System.out.println(new KokoEatingBanana_875().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6)); // 23
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canEatWithinTime(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canEatWithinTime(int[] piles, int speed, int h) {
        int hoursConsumed = 0;

        for (int pile : piles) {
            hoursConsumed += (pile + speed - 1) / speed;

            if (hoursConsumed > h) return false;
        }
        return true;
    }
}
