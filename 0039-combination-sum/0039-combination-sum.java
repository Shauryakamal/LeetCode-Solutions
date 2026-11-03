class Solution {
    public static void backtrack(int index,int arr[], int target, List<List<Integer>> result, List<Integer> current){
        if(index == arr.length){
            if(target == 0){
                result.add(new ArrayList<>(current));
            }
            return;
        }
            if(arr[index] <= target){
                current.add(arr[index]);
                backtrack(index,arr,target-arr[index],result,current);
                current.remove(current.size() -1);
            }
            backtrack(index + 1, arr,target,result,current);
        }
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,candidates,target,result,new ArrayList<>());
        return result;
    }
    }
    

