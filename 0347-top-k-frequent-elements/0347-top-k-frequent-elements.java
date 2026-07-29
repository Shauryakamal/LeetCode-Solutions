class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(pq.size() < k){
                pq.add(entry);
            }else{
                if(entry.getValue() > pq.peek().getValue()){
                    pq.poll();
                    pq.add(entry);
                }
            }
        }
        int[] ans = new int[k];
        for(int i = 0; i<ans.length;i++){
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}