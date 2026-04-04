package Strings.TwoPointer;

public class ReverseWordInString_151 {
    public static void main(String[] args) {
        System.out.println(new ReverseWordInString_151().reverseWords("  hello world  ")); // "world hello"
        System.out.println(new ReverseWordInString_151().reverseWords("a good   example")); // "example good a"
    }
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();

        // 1. reverse whole string
        reverse(arr, 0, arr.length - 1);

        // 2. reverse each word
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == ' ') continue;

            start = end;

            while (end < arr.length && arr[end] != ' ') {
                end++;
            }

            reverse(arr, start, end - 1);
        }

        // 3. clean spaces
        return cleanSpaces(arr);
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private String cleanSpaces(char[] arr) {
        int n = arr.length;
        int i = 0, j = 0;

        while (j < n) {
            // skip spaces
            while (j < n && arr[j] == ' ') j++;

            // copy word
            while (j < n && arr[j] != ' ') {
                arr[i++] = arr[j++];
            }

            // skip spaces between words
            while (j < n && arr[j] == ' ') j++;

            // add single space
            if (j < n) {
                arr[i++] = ' ';
            }
        }

        return new String(arr, 0, i);
    }
}
