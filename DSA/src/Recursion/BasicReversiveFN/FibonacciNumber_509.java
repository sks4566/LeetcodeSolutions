package Recursion.BasicReversiveFN;

public class FibonacciNumber_509 {
    public static void main(String[] args) {
        System.out.println(new FibonacciNumber_509().fib(5));
    }
    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }
}
