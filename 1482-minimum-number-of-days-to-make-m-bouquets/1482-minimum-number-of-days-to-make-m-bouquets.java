class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m * k > bloomDay.length){
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int ans = -1;
        for(int bloom : bloomDay){
            low = Math.min(low,bloom);
            high = Math.max(high,bloom);
        }
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canMake(bloomDay,mid,m,k)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean canMake(int[] bloomDay, int day, int m, int k){
        int count = 0;
        int bouqet = 0;
        for(int bloom : bloomDay){
            if(bloom <= day){
                count++;
                if(count == k){
                    bouqet++;
                    count = 0;
                }
            }else{
                count = 0;
            }
        }
        return bouqet >= m;
    }
}