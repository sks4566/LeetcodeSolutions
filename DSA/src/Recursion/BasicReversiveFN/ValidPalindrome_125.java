package Recursion.BasicReversiveFN;

public class ValidPalindrome_125 {
    public static void main(String[] args) {
        System.out.println(new ValidPalindrome_125().isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return check(cleaned, 0, cleaned.length() - 1);
    }

    private boolean check(String s, int left, int right) {
        if (left >= right) return true;

        if (s.charAt(left) != s.charAt(right)) return false;

        return check(s, left + 1, right - 1);
    }
}
