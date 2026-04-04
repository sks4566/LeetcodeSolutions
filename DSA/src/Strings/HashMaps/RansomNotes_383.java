package Strings.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class RansomNotes_383 {

    public static void main(String[] args) {
        System.out.println(new RansomNotes_383().canConstruct("a", "b")); // false
        System.out.println(new RansomNotes_383().canConstruct("aa", "ab")); // false
        System.out.println(new RansomNotes_383().canConstruct("aa", "aab")); // true
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }

        return true;
    }
}
