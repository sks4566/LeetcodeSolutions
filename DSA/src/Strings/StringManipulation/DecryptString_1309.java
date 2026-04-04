package Strings.StringManipulation;

public class DecryptString_1309 {
    public static void main(String[] args) {
        System.out.println(new DecryptString_1309().freqAlphabets("10#11#12")); // "jkab"
        System.out.println(new DecryptString_1309().freqAlphabets("1326#")); // "acz"
    }
    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); ) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                int num = Integer.parseInt(s.substring(i, i + 2));
                result.append((char)('a' + num - 1));
                i += 3;
            } else {
                int num = s.charAt(i) - '0';
                result.append((char)('a' + num - 1));
                i++;
            }
        }

        return result.toString();
    }
}
