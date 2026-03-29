package BinrarySearch.RangeBinarySearch;

public class CapacityToShip_1011 {
    public static void main(String[] args) {
        System.out.println(new CapacityToShip_1011().shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5)); // 15
    }
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for(int weight : weights){
            left = Math.max(left, weight);
            right+= weight;
        }
        while(left< right){
            int mid = left + (right -left)/2;
            if(canShip(weights, mid, days)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canShip(int[] weights, int capacity, int days) {
        int daysUsed = 1;
        int currentSum = 0;

        for (int weight : weights) {
            if (currentSum + weight > capacity) {
                daysUsed++;
                currentSum = weight;
            } else {
                currentSum += weight;
            }
        }

        return daysUsed <= days;
    }
}
