public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if ((p == null && q != null) || (p != null && q == null) || (q.val != p.val))
            return false;

        if (!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right))
            return false;

        return true;
    }
}
