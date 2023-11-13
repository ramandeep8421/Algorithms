public class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode node, long lb, long ub) {
        if (node == null) return true;

        if (node.val >= ub || node.val <= lb) return false;

        return check(node.left, lb, node.val) && check(node.right, node.val, ub);
    }
}
