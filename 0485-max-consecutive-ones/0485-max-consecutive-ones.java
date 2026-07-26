class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int k =0;
        int max = 0;
        for(int i =0 ; i<arr.length;i++){
            if(arr[i] == 1){
                k++;
                max = Math.max(max,k);
            }else{
                k = 0;
            }
        }
        return max;
    }
}