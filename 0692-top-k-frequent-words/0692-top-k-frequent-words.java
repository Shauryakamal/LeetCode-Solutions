class Solution {
    public List<String> topKFrequent(String[] words, int k) {
           HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
            int freq = Integer.compare(a.getValue(), b.getValue());
            if (freq != 0) {
                return freq;
            } else {
                return b.getKey().compareTo(a.getKey());
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }
}