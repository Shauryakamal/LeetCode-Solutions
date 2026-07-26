class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            int partitions = calculatePartions(nums, mid);
            if (partitions <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public int calculatePartions(int[] nums, int maxAllowedSum){
        int partitions =1;
        int currentSum = 0;
        for(int num : nums){
            if(currentSum + num >maxAllowedSum ){
                partitions++;
                currentSum = num;
            }else{
                currentSum += num;
            }
        }
        return partitions;
    }
}