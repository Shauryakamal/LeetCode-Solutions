class Solution {
       public static int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        int maxFreq = 0;
        int maxCount = 0;

        for (int count : freq.values()) {
           if(count > maxFreq){
            maxFreq = count;
            maxCount = 1;
           }else if(count == maxFreq){
            maxCount++;
           }
        }
        int intervals = (maxFreq - 1) * (n + 1) + maxCount;

        return Math.max(intervals, tasks.length);
    }
}