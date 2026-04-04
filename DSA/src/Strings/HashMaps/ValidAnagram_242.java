package Strings.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {
    public static void main(String[] args) {
        System.out.println(new ValidAnagram_242().isAnagram("anagram", "nagaram")); // true
        System.out.println(new ValidAnagram_242().isAnagram("rat", "car")); // false
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map  = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+ 1);
        }

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c,0) - 1);
            if(map.get(c) < 0){
                return false;
            }
        }
        return true;
    }
}
