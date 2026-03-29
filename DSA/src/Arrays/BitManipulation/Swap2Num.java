package Arrays.BitManipulation;

public class Swap2Num {
    public static void main(String[] args) {
        printSwap(2,3);
    }

    public static void printSwap(int a , int b){
        System.out.println("Before Swap");
        System.out.println(a + "  " + b);
        a=a^b;
        b = a^b;
        a= a^b;
        System.out.println("After Swap");
        System.out.println(a + "  " + b);
    }
}
