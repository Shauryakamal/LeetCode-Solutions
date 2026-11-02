class Solution {
    public static void backTrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        backTrack(index + 1, nums,current,result);
        current.remove(current.size()-1);
        backTrack(index + 1, nums,current,result);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backTrack(0,nums,current,result);
        return result;
    }
}