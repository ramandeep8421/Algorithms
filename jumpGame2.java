public class Solution {
    public int jumpGameII(int[] jumps) {
        int answer = 0;
        int left = 0, right = 0;

        int n = jumps.length;

        while (right < n) {
            int farthest = 0;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + jumps[i]);
            }
            left = right + 1;
            right = farthest;
            answer++;
        }

        return answer;
    }
}




  
        
