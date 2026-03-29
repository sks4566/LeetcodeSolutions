package BinrarySearch.BasicBinarySearch;

public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(new ArrangeCoins().arrangeCoins(5)); // 2
        System.out.println(new ArrangeCoins().arrangeCoins(8)); // 3
    }
    public int arrangeCoins(int n) {
        long left  = 0;
        long right = n;
        while(left <= right){
            long mid = left + (right - left)/2;
            long coins = mid * (mid + 1) / 2;
            if (coins == n) {
                return (int) mid;
            } else if (coins < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) right;
    }
}
