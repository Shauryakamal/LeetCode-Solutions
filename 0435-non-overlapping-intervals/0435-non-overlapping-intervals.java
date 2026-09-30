class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // overLap
            if (intervals[i][0] < prevEnd) {
                count++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}