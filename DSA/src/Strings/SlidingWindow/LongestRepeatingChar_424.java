package Strings.SlidingWindow;

public class LongestRepeatingChar_424 {
    public static void main(String[] args) {
        System.out.println(new LongestRepeatingChar_424().characterReplacement("ABAB", 2)); // 4
        System.out.println(new LongestRepeatingChar_424().characterReplacement("AABABBA", 1)); // 4
    }
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'A';
            freq[index]++;

            maxFreq = Math.max(maxFreq, freq[index]);

            // check validity
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
