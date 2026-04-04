package Recursion.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current,
                           int[] candidates, int target, int start) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {

            // Choose
            current.add(candidates[i]);

            // Explore (same i → reuse allowed)
            backtrack(result, current, candidates, target - candidates[i], i);

            // Undo (backtrack)
            current.remove(current.size() - 1);
        }
    }
}
