import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }

    private void helper(TreeNode node, int level, List<Integer> ans) {
        if (node == null) return;

        if (level == ans.size()) {
            ans.add(node.val);
        }

        helper(node.right, level + 1, ans);
        helper(node.left, level + 1, ans);
    }
}
