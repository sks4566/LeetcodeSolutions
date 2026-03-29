package Arrays.NumberTheory;

public class AddWithoutPlus {
    public static void main(String[] args) {
        System.out.println(add(2,5));
    }

    public static int add(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return add(num1 ^ num2, (num1 & num2) << 1);
    }
}
