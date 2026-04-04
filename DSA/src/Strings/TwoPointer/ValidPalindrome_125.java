package Strings.TwoPointer;

import java.util.Arrays;

public class ValidPalindrome_125 {
    public static void main(String[] args) {
        String s = "the sky is     blue";
        System.out.println(Arrays.toString(s.split(" ")));




        System.out.println(new ValidPalindrome_125().isPalindrome("A man, a plan, a canal: Panama"));
    }
    public boolean isPalindrome(String s) {
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleanedString.length() - 1;

        while (left < right) {
            if (cleanedString.charAt(left) != cleanedString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
