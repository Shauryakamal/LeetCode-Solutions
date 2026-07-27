class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] result = new int[nums.length];
        int index = result.length-1;
        while(left <= right){
            int leftsquare = nums[left] * nums[left];
            int rightsquare = nums[right] * nums[right];
            if(leftsquare > rightsquare){
                result[index] = leftsquare;
                left++;
            }else{
                result[index] = rightsquare;
                right--;
            }
            index--;
        }
        return result;
    }
}