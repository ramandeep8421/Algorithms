import java.util.*;

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> st = new Stack<>();

        int count = 1;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (st.empty()) {
                st.push(new Pair<Character, Integer>(s.charAt(i), count));
                continue;
            } else if (st.peek().first == s.charAt(i)) {
                st.peek().second++;

                if (st.peek().second == k) {
                    st.pop();
                }
            } else {
                count = 1;
                st.push(new Pair<Character, Integer>(s.charAt(i), count));
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!st.empty()) {
            while (st.peek().second > 0) {
                ans.append(st.peek().first);
                st.peek().second--;
            }
            st.pop();
        }

        return ans.reverse().toString();
    }
}

     

      
      
     


      
