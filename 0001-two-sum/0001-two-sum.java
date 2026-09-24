import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check karo complement pehle se map mein hai kya
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Current number ko map mein daal do future reference ke liye
            map.put(nums[i], i);
        }

        return new int[] {}; // agar koi solution nahi mila
    }
}