import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
        data = 0;
        left = null;
        right = null;
    }
}

class Solution {
    int ans;

    // function to find the longest
    // univalue path
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        directionalLength(root);
        return ans;
    }

    // Function to find the longestUnivaluePath
    public int directionalLength(TreeNode root) {
        // if we have empty tree, then return 0
        if (root == null)
            return 0;

        // find the directionalLength for left subtree
        int left = directionalLength(root.left);

        // find the directionalLength for right subtree
        int right = directionalLength(root.right);

        // integers to store the length values
        int dirRight = 0, dirLeft = 0;

        // check for the longest univalue path
        // in the left subtree
        if (root.left != null && root.left.data == root.data) {
            dirLeft += (left + 1);
        }

        // check for the longest univalue path in the right subtree
        if (root.right != null && root.right.data == root.data) {
            dirRight += (right + 1);
        }

        // find the max of the ans with the sum of univalue path
        ans = Math.max(ans, dirLeft + dirRight);

        // return the max of left and right longest
        // univalue path
        return Math.max(dirLeft, dirRight);
    }
}
