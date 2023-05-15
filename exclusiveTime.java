import java.util.*;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        // answer array to store the final answer
        int[] ans = new int[n];

        // declare a stack to store the pairs
        Stack<Pair<Integer, Integer>> cur = new Stack<>();

        // prev time variable
        int prevTime = 0;

        for (String s : logs) {
            int id = Integer.parseInt(s.substring(0, s.indexOf(':')));
            int time = Integer.parseInt(s.substring(s.lastIndexOf(':') + 1));

            if (s.contains("end")) {
                ans[id] += time - prevTime + 1;
                cur.pop();
                prevTime = time + 1;
            } else {
                if (!cur.isEmpty())
                    ans[cur.peek().getKey()] += (time - prevTime);
                cur.push(new Pair<>(id, time));
                prevTime = time;
            }
        }

        return ans;
    }
}

