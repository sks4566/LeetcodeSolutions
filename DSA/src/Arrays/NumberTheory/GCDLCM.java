package Arrays.NumberTheory;

public class GCDLCM {
    public static void main(String[] args) {
        System.out.println(solution(30,40,400));
    }

    public static int solution(int x, int y, int z){
        int lcm1 = lcm(x,y);
        int lcm2 = lcm(x,z);
        return gcd(lcm1, lcm2);
    }

    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }

    public static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
}
