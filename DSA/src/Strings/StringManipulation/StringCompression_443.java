package Strings.StringManipulation;

public class StringCompression_443 {
    public static void main(String[] args) {
        char[] arr1 = new char[]{'a','a','b','b','c','c','c'};
        int len1 = new StringCompression_443().compress(arr1);
        System.out.println(len1 + " -> " + new String(arr1, 0, len1)); // 6 -> a2b2c3

        char[] arr2 = new char[]{'a'};
        int len2 = new StringCompression_443().compress(arr2);
        System.out.println(len2 + " -> " + new String(arr2, 0, len2)); // 1 -> a

        char[] arr3 = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}; // a followed by 12 b's
        int len3 = new StringCompression_443().compress(arr3);
        System.out.println(len3 + " -> " + new String(arr3, 0, len3)); // expected: 4 -> ab12
    }

    public int compress(char[] chars) {
        int index = 0;
        int i = 0;

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            chars[index++] = currentChar;

            if (count > 1) {
                String countStr = Integer.toString(count);
                for (char c : countStr.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}
