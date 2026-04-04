package Strings.SlidingWindow;

public class MaxNoOfVowel_1456 {
    public static void main(String[] args) {
        System.out.println(new MaxNoOfVowel_1456().maxVowels("abciiidef", 3)); // 3
        System.out.println(new MaxNoOfVowel_1456().maxVowels("aeiou", 2)); // 2
        System.out.println(new MaxNoOfVowel_1456().maxVowels("leetcode", 3)); // 2
    }

    public int maxVowels(String s, int k) {
        int maxCount = 0;
        int count = 0;

        // initial window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        maxCount = count;

        // slide window
        for (int i = k; i < s.length(); i++) {
            // add new char
            if (isVowel(s.charAt(i))) {
                count++;
            }

            // remove old char
            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
