package BinrarySearch.BasicBinarySearch;

public class SmallestChatGreaterThanTarget {
    public static void main(String[] args) {
        System.out.println(new SmallestChatGreaterThanTarget().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a')); // 'c'
    }
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return letters[left % letters.length]; // wrap-around
    }
}
