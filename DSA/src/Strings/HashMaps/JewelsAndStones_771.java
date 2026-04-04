package Strings.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones_771 {
    public static void main(String[] args) {
        System.out.println(new JewelsAndStones_771().numJewelsInStones("aA", "aAAbbbb")); // 3
        System.out.println(new JewelsAndStones_771().numJewelsInStones("z", "ZZ")); // 0
    }
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();

        // count all stones
        for (char c : stones.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;

        // check jewels
        for (char c : jewels.toCharArray()) {
            count += map.getOrDefault(c, 0);
        }

        return count;
    }
}
