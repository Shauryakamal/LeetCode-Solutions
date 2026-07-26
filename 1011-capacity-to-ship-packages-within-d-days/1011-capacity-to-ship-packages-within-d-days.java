class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low =0;
        for(int weight : weights){
            low = Math.max(low,weight);
        }
        int high = 0;
        for(int weight : weights){
            high += weight;
        }
        while(low < high){
            int mid = low + (high - low)/2;
            long day = calculateDays(weights, mid);
            if( day <= days){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public int calculateDays(int[] weights, int capacity){
        int days = 1;
        int currentLoad = 0;
        for(int weight : weights){
            if(currentLoad + weight > capacity){
                days++;
                currentLoad = weight;
            }else{
                currentLoad += weight;
            }
        }
        return days;
    }
}