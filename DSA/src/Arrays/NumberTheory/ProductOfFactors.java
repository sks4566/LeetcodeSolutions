package Arrays.NumberTheory;

//https://www.geeksforgeeks.org/problems/product-of-factors-of-number4757/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
public class ProductOfFactors {
    public static void main(String[] args) {
        System.out.println(factorProduct(25));
    }

   public static int factorProduct(int N) {
           long product = 1l;
           long mod = 1000000007l;
           for (int i = 1; i * i <= N; i++) {
               if (N % i == 0) {
                   if (N / i == i) {
                       product = (product * i) % mod;
                   } else {
                       product = (product * i * (N / i)) % mod;
                   }
               }
           }
               return (int) product;
    }
}
