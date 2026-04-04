package Strings.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagram_438 {

    public static void main(String[] args) {
        System.out.println(new FindAllAnagram_438().findAnagrams("cbaebabacd", "abc")); // [0, 6]
        System.out.println(new FindAllAnagram_438().findAnagrams("abab", "ab")); // [0, 1, 2]
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) return result;

        int[] pFreq = new int[26];
        int[] window = new int[26];

        // build p frequency
        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }

        int k = p.length();

        for (int i = 0; i < s.length(); i++) {
            // add current char
            window[s.charAt(i) - 'a']++;

            // remove left char if window > k
            if (i >= k) {
                window[s.charAt(i - k) - 'a']--;
            }

            // compare
            if (Arrays.equals(window, pFreq)) {
                result.add(i - k + 1);
            }
        }

        return result;
    }
}
