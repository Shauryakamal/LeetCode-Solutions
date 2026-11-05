class Solution {
    public static void backtrack(int index, String digits, String[] mapping, List<String> current, List<String> result){
        if(index >= digits.length()){
            result.add(String.join("",current));
            return;
        }
        String value = mapping[digits.charAt(index) -'0'];
        for(int i = 0; i<value.length();i++){
            char letter = value.charAt(i);
            current.add(String.valueOf(letter));
            backtrack(index + 1, digits,mapping,current,result);
            current.remove(current.size() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> current = new ArrayList<>();
        List<String> result = new ArrayList<>();
        String[] mapping = {
                "", "", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        backtrack(0,digits,mapping,current,result);
        return result;
    }
}