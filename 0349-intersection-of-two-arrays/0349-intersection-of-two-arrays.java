class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int num : nums1){
            set.add(num);
        }
        for(int num : nums2){
            if(set.contains(num)){
                result.add(num);
                set.remove(num);
            }
        }
        int[] ans = new int[result.size()];
        for(int i = 0; i<ans.length; i++){
            ans[i] = result.get(i);
        }
         return ans;
    }
}