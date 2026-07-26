class Solution {
    public int[] intersect(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        for(i = 0, j = 0; i<arr1.length && j<arr2.length;){
            if(arr1[i] < arr2[j]){
                i++;
            }else if(arr2[j] < arr1[i]){
                j++;
            }else{
                result.add(arr1[i]);
                i++;
                j++;
            }
        }
        int[] ans = new int[result.size()];
        for(int k = 0; k<result.size();k++){
            ans[k] = result.get(k);
        }
        return ans;
    }
}