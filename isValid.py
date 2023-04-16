class Solution:

    # Function to check for a valid parenthesis string
    def isValidParenthesis(self, s: str) -> bool:
        # size of the string s
        n = len(s)

        # Declare a stack
        st = []

        # Iterate over the string
        for i in range(n):
            if s[i] == '{' or s[i] == '[' or s[i] == '(':
                st.append(s[i])
            else:
                if not st or (s[i] != ')' and st[-1] == '(') or (s[i] != ']' and st[-1] == '[') or (st[-1] == '{' and s[i] != '}'):
                    return False
                st.pop()

        return not st
