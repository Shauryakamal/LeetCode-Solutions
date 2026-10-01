class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        // Store last occurrence of every character
        Map<Character, Integer> last = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            last.put(s.charAt(i), i);
        }

        int end = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            // Extend partition boundary
            end = Math.max(end, last.get(s.charAt(i)));

            // Partition complete
            if (i == end) {
                result.add(i - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}