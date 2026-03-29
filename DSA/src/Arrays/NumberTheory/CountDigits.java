package Arrays.NumberTheory;

public class CountDigits {
    public static void main(String[] args) {
        System.out.println(countDigits(1234));
    }

    public static int countDigits(int n){
        return (int)Math.log10(n) + 1;
    }
}
