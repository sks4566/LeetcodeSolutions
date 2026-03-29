package Arrays.NumberTheory;

public class MegaPrime {
    public static void main(String[] args) {
        long first = 1;
        long last = 100;
        System.out.println(countMegaPrimes((int) first, (int) last));
    }


    public static int countMegaPrimes(int first, int last){
        boolean[] isPrime = new boolean[last - first +1];

        // Initialize isPrime array
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        // Sieve of Eratosthenes algorithm
        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count_prime = 0;
        for(int i=first;i<last-first+1;i++)
            if(isPrime[i] && isMegaPrime(i))//checking mega prime
                ++count_prime;
        return count_prime;
    }

    public static boolean isMegaPrime(int N){
        int dig = N%10;
        if(dig != 2 && dig != 3 && dig != 5 && dig != 7 )
            return false;
        return (N>10)?isMegaPrime(N/10):true;
    }
}
