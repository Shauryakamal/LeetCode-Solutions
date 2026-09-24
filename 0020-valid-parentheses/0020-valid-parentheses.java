import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // Opening bracket hai, stack mein push karo
                stack.push(c);
            } else {
                // Closing bracket hai, stack empty hai toh invalid
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                // Matching opening bracket honi chahiye
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // Sab match ho gaye toh stack empty honi chahiye
        return stack.isEmpty();
    }
}