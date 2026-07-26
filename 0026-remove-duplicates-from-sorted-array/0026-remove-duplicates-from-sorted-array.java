class Solution {
    public int removeDuplicates(int[] arr) {
        int k = 0;
        for(int i = 0; i<arr.length; i++){
            if(i == 0 || arr[i] != arr[i-1]){
                arr[k] = arr[i];
                k++;
            }
        }
        for(int i =0 ;i<k; i++){
            System.out.println(arr[i]);
        }
        return k;
    }
    
}