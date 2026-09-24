class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);   // sorting sabse important step hai yahan

        for (int i = 0; i < nums.length - 2; i++) {
            // Same element se duplicate triplet skip karo
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Agar smallest element hi positive hai, sum 0 kabhi nahi banega
            if (nums[i] > 0) break;

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Duplicates skip karo dono pointers ke liye
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;   // sum badhana hai, toh chhote wale ko aage badhao
                } else {
                    right--;  // sum ghatana hai, toh bade wale ko peeche lao
                }
            }
        }

        return result;
    }
}