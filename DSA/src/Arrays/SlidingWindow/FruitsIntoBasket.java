package Arrays.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        System.out.println(new FruitsIntoBasket().totalFruit(new int[]{1,2,1}));
        System.out.println(new FruitsIntoBasket().totalFruit(new int[]{0,1,2,2}));
        System.out.println(new FruitsIntoBasket().totalFruit(new int[]{1,2,3,2,2}));
    }
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int right = 0; right < fruits.length; right++) {

            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0)
                    map.remove(fruits[left]);

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
