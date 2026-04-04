package Strings.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter_387 {
    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacter_387().firstUniqChar("leetcode")); // 0
        System.out.println(new FirstUniqueCharacter_387().firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
