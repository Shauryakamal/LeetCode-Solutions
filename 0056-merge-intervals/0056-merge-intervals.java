import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Start time ke basis pe sort karo
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);

        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                // Overlap hai, toh end ko extend karo
                current[1] = Math.max(current[1], interval[1]);
            } else {
                // Overlap nahi hai, naya interval start karo
                current = interval;
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}