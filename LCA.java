import java.util.*;

// Definition for TreeNode
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Solution {
    TreeNode ans;

    boolean recursionTree(TreeNode currNode, TreeNode p, TreeNode q) {
        if (currNode == null) {
            return false;
        }

        int left = recursionTree(currNode.left, p, q) ? 1 : 0;
        int right = recursionTree(currNode.right, p, q) ? 1 : 0;

        int mid = (currNode == p || currNode == q) ? 1 : 0;

        if (mid + left + right >= 2) {
            ans = currNode;
        }

        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursionTree(root, p, q);
        return ans;
    }
}
