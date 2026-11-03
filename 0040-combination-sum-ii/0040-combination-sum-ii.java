class Solution {
    public void backtrack(int index, int[] arr, int target, List<List<Integer>> result,List<Integer> current){
        if(target == 0){
            result.add(new ArrayList<>(current));
        }
        for(int i = index; i<arr.length; i++){
            if(i > index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            current.add(arr[i]);
            backtrack(i + 1, arr, target - arr[i], result, current);
            current.remove(current.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,candidates,target,result,new ArrayList<>());
        return result;
    }
}