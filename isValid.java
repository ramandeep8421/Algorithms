import java.util.Stack;

class Solution {

    // Function to check for a valid parenthesis string
    public static boolean isValidParenthesis(String s) {
        // size of the string s
        int n = s.length();

        // Declare a stack
        Stack<Character> st = new Stack<>();

        // Iterate over the string
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else {
                if (st.empty() || (s.charAt(i) != ')' && st.peek() == '(')
                        || (s.charAt(i) != ']' && st.peek() == '[')
                        || (st.peek() == '{' && s.charAt(i) != '}')) {
                    return false;
                }
                st.pop();
            }
        }

        return st.empty();
    }
}
