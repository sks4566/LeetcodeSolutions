package Recursion.BasicReversiveFN;

public class GoodNumbers_1922 {
    public static void main(String[] args) {
        System.out.println(new GoodNumbers_1922().countGoodNumbers(50));
    }
    public int countGoodNumbers(long n) {
        long mod = 1_000_000_007;

        long even = (n + 1) / 2;
        long odd = n / 2;

        long result = (power(5, even, mod) * power(4, odd, mod)) % mod;

        return (int) result;
    }

    private long power(long x, long n, long mod) {
        if (n == 0) return 1;

        long half = power(x, n / 2, mod);

        if (n % 2 == 0) {
            return (half * half) % mod;
        } else {
            return (half * half % mod * x) % mod;
        }
    }
}
