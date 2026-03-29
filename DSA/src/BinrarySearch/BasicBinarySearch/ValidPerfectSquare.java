package BinrarySearch.BasicBinarySearch;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(16)); // true
    }

    public boolean isPerfectSquare(int num) {
        int l = 1;
        int r = num;
        while(l < r){
            int mid = l + (r-l)/2;
            if(mid >= num/mid){
                r = mid;
            }else{
                l = mid +1;
            }

        }

        return l*l == num;
    }
}
