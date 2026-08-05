class Solution {
    public int findKthLargest(int[] arr, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for(int num : arr){
        minHeap.offer(num);
        if(minHeap.size()>k){
            minHeap.poll();
        }
    }
    return minHeap.peek();
}
}