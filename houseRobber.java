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
    public int rob(TreeNode root) {
        Pair<Integer, Integer> p = solve(root);
        return Math.max(p.getKey(), p.getValue());
    }

    public Pair<Integer, Integer> solve(TreeNode root) {
        if (root == null) {
            return new Pair<>(0, 0);
        }
        Pair<Integer, Integer> p1 = solve(root.left);
        Pair<Integer, Integer> p2 = solve(root.right);
        Pair<Integer, Integer> p = new Pair<>(0, 0);
        p = new Pair<>(root.val + p1.getValue() + p2.getValue(), 
                       Math.max(p1.getKey(), p1.getValue()) + Math.max(p2.getKey(), p2.getValue()));
        return p;
    }
}

 
       
        
       
        
