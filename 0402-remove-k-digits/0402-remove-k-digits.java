class Solution {
    public String removeKdigits(String num, int k) {
        
        // Step 1: StringBuilder as a Stack
        StringBuilder stack = new StringBuilder();

        // Step 2: Greedy Monotonic Stack
        for (int i = 0; i < num.length(); i++) {

            char digit = num.charAt(i);

            while (stack.length() > 0 &&
                   k > 0 &&
                   stack.charAt(stack.length() - 1) > digit) {

                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(digit);
        }

        // Step 3: Remove remaining k digits from the end
        while (k > 0 && stack.length() > 0) {

            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Step 4: Remove leading zeroes
        int start = 0;

        while (start < stack.length() && stack.charAt(start) == '0') {
            start++;
        }

        // Step 5: Handle empty result
        if (start == stack.length()) {
            return "0";
        }

        return stack.substring(start);
    }
}