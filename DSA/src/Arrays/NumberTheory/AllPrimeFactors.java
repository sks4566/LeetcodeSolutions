package Arrays.NumberTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AllPrimeFactors {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(AllPrimeFactors(100)));
    }

    public static int[] AllPrimeFactors(int N) {
        // code here
        List<Integer> list = new ArrayList<>();
        int j=0;
        int prime=0;
        for(int i=2; i*i<=N; i++)
        {
            while(N%i==0)
            {
                if(i!=prime)
                {
                    list.add(i);
                }
                prime=i;


                N=N/i;
            }
        }
        if(N>1)
        {
            list.add(N);
        }

        int[] ans = new int[list.size()];
        int k=0;
        for(int val:list)
        {
            ans[k]=val;
            k++;
        }
        return ans;
    }
}