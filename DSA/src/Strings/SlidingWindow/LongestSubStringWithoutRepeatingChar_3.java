package Strings.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingChar_3 {

    public static void main(String[] args) {
        System.out.println(new LongestSubStringWithoutRepeatingChar_3().lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(new LongestSubStringWithoutRepeatingChar_3().lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(new LongestSubStringWithoutRepeatingChar_3().lengthOfLongestSubstring("pwwkew")); // 3
    }
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxSubStringLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // shrink window until valid
            while (map.get(c) > 1) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            maxSubStringLength = Math.max(maxSubStringLength, right - left + 1);
        }

        return maxSubStringLength;
    }
}
