class Solution {

    public int[] searchRange(int[] arr, int target){
       int first = firstOccurance(arr,target);
       int last = lastOccurance(arr,target);
        return new int[]{first,last};
    }
    private int firstOccurance(int[] arr, int target) {
        int low = 0;
        int high = arr.length -1 ;
        int ans = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                ans = mid;
                high = mid - 1;
            }else if(target > arr[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    private int lastOccurance(int[] arr, int target){
        int low = 0;
        int high = arr.length -1 ;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                ans = mid;
                low = mid + 1;
            }else if(target > arr[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
}