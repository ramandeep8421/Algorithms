public class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans++;
            }
            n = n >>> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 11; // Replace 11 with your input value
        int result = solution.hammingWeight(n);
        System.out.println("Hamming weight: " + result);
    }
}
