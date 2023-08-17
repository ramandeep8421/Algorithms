class Solution {
    static class TrieNode {
        TrieNode zero;
        TrieNode one;
    }

    void insert(TrieNode root, int n) {
        TrieNode curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            if (bit == 0) {
                if (curr.zero == null) {
                    TrieNode newNode = new TrieNode();
                    curr.zero = newNode;
                }
                curr = curr.zero;
            } else {
                if (curr.one == null) {
                    TrieNode newNode = new TrieNode();
                    curr.one = newNode;
                }
                curr = curr.one;
            }
        }
    }

    int maximizeXor(TrieNode root, int n) {
        TrieNode curr = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            if (bit == 1) {
                if (curr.zero != null) {
                    ans += (1 << i);
                    curr = curr.zero;
                } else {
                    curr = curr.one;
                }
            } else {
                if (curr.one != null) {
                    ans += (1 << i);
                    curr = curr.one;
                } else {
                    curr = curr.zero;
                }
            }
        }
        return ans;
    }

    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        TrieNode root = new TrieNode();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            insert(root, nums[i]);
        }
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, maximizeXor(root, nums[i]));
        }
        return ans;
    }
}
