package Arrays.NumberTheory;

import java.util.Arrays;

public class LCMAndGCD {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(lcmAndGcd(5,10)));
    }

    public static int[] lcmAndGcd(int a, int b){
        int gcd = gcd(a, b);
        int lcm = a*b/gcd;
        return new int[]{lcm, gcd};
    }

    public static int gcd(int a, int b){
        if(b ==0){
            return a;
        }
        return gcd(b, a%b);
    }
}
