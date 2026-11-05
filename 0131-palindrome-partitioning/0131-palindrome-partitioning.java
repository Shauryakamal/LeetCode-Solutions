class Solution {
    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        backtrack(s,0,path,result);
        return result;
    }
    public static void backtrack( String s, int index,List<String> path, List<List<String>> result){
        if(index == s.length()){//base case
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i<s.length(); i++){
            if(isPallindrone(s,index,i)){
                path.add(s.substring(index,i+1));
                backtrack(s, i+1, path,result);
                path.remove(path.size()-1);
            }
        }
    }
    public static boolean isPallindrone(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}