package Arrays.NumberTheory;

import java.util.ArrayList;

public class FactorialLessThanN {
    public static void main(String[] args) {
        System.out.println(factorialNumbers(26));
    }

    static ArrayList<Long> factorialNumbers(long n) {
        // code here
        ArrayList<Long> ans = new ArrayList<>();
        long fact = 1;
        int i = 1;
        while(fact<=n){
            ans.add(fact);
            i++;
            fact = fact*i;
        }
        return ans;
    }
}
