package Arrays.NumberTheory;

public class NcR {
    public static void main(String[] args) {
        System.out.println(fact(84,66));
    }

    public static int fact(int n, int r){
        int fact = 1;
        int a = 1;
        int diff = 1;
        if(r == 0){
            return 1;
        }
        for(int i =2 ; i <=n; i++){
            fact = fact*i;
            if(i == r){
                a  = fact;
            }else if(i == n-r){
                diff = fact;
            }
        }
        return (fact/(a*diff))%142857;
    }
}
