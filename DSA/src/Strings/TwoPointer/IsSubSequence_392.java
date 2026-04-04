package Strings.TwoPointer;

public class IsSubSequence_392 {
    public static void main(String[] args) {
        System.out.println(new IsSubSequence_392().isSubsequence("abc", "ahbgdc")); // true
        System.out.println(new IsSubSequence_392().isSubsequence("axc", "ahbgdc")); // false
    }
    public boolean isSubsequence(String s, String t) {
        int left = 0;
        int right  = 0;
        while(left < s.length() && right < t.length()){
            if(t.charAt(right) != s.charAt(left)){
                right++;
            }else{
                left++;
                right++;
            }
        }
        return left == s.length();
    }
}
