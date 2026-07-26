class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int pile : piles){
             high = Math.max(high,pile);
        }
            while(low < high){
                int mid = low +(high - low)/2;
                long hours = calculateHours(piles,mid);
                if(hours <= h){
                    high = mid;
                }else{
                    low = mid + 1;
                }
            }
            return low; 
    }
    private long calculateHours(int[] piles, int speed){
        long totalHours = 0;
        for(int pile : piles){
            totalHours += (pile + speed - 1) / speed;
        }
        return totalHours;
    }
    
}