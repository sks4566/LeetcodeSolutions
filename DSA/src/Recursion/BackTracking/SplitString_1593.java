package Recursion.BackTracking;

import java.util.HashSet;
import java.util.Set;

public class SplitString_1593 {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int index, Set<String> set) {
        if (index == s.length()) {
            return set.size();
        }

        int max = 0;

        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);


            if (set.contains(substring)) continue;

            // choose
            set.add(substring);

            // explore
            max = Math.max(max, backtrack(s, i + 1, set));

            // undo (backtrack)
            set.remove(substring);
        }

        return max;
    }
}
