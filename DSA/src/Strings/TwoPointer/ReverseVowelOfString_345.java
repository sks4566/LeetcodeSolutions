package Strings.TwoPointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelOfString_345 {
    public static void main(String[] args) {
        System.out.println(new ReverseVowelOfString_345().reverseVowels("hello"));
        System.out.println(new ReverseVowelOfString_345().reverseVowels("leetcode"));
    }
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(
                Arrays.asList('a','e','i','o','u','A','E','I','O','U')
        );

        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            // move left to vowel
            while (left < right && !vowels.contains(arr[left])) {
                left++;
            }

            // move right to vowel
            while (left < right && !vowels.contains(arr[right])) {
                right--;
            }

            // swap
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }
}
