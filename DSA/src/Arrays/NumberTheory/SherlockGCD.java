package Arrays.NumberTheory;

import java.util.Arrays;
import java.util.List;

public class SherlockGCD {
    public static void main(String[] args) {
        System.out.println(sherlockGCD(Arrays.asList(5,5,5)));
    }

    public static String sherlockGCD(List<Integer> list){
        int val = 0;
        for(int i =0 ; i < list.size() ; i++){
            if(i == 0){
                val = list.get(i);
            }else{
                val = gcd(val, list.get(i));
            }
        }
        return val == 1 ? "YES" : "NO";

    }

    public static int gcd(int a , int b){
        if(b == 0){
            return a;
        }else{
           return gcd(b, a%b);
        }
    }
}
