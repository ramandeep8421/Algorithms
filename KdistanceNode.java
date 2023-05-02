import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Dist {
    TreeNode node;
    int distance;
    Dist(TreeNode node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {

    List<Integer> res = new ArrayList<>();
    Map<TreeNode, TreeNode> mp = new HashMap<>();

    //Function to annotate parent
    public void dfs(TreeNode root, TreeNode parent) {
        if (root == null) return;
        mp.put(root, parent);
        dfs(root.left, root);
        dfs(root.right, root);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //In case of an empty tree
        if (root == null) return res;

        //call the DFS function to annotate the binary tree
        dfs(root, null);

        //queue 
        Queue<Dist> qu = new LinkedList<>();
        qu.offer(new Dist(target, 0));

        Map<TreeNode, Boolean> vis = new HashMap<>();
        vis.put(target, true);

        while (!qu.isEmpty()) {
            Dist d = qu.poll();
            if (d.distance == k) {
                res.add(d.node.val);
                continue;
            }
            if (d.node.left != null && !vis.containsKey(d.node.left)) {
                qu.offer(new Dist(d.node.left, d.distance + 1));
                vis.put(d.node.left, true);
            }
            if (d.node.right != null && !vis.containsKey(d.node.right)) {
                qu.offer(new Dist(d.node.right, d.distance + 1));
                vis.put(d.node.right, true);
            }
            if (mp.containsKey(d.node) && !vis.containsKey(mp.get(d.node))) {
                qu.offer(new Dist(mp.get(d.node), d.distance + 1));
                vis.put(mp.get(d.node), true);
            }
        }
        return res;
    }
}
