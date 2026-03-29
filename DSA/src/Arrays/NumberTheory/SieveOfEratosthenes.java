package Arrays.NumberTheory;

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {

    public static void main(String[] args) {

    }

    public static List<Integer> findAllPrimeTillNumber(int N){
        boolean[] isPrime = new boolean[N + 1];
        List<Integer> primes = new ArrayList<>();

        // Initialize isPrime array
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        // Sieve of Eratosthenes algorithm
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Store prime numbers in the list
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;

    }
}
