import java.util.LinkedList;
import java.util.Queue;

//Definition for treeNode
class TreeNode{
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x){
      val = x;
      left = null;
      right = null;
   }
}

class Solution {
   public int countNodes(TreeNode root){
      //Empty tree
      if(root == null) return 0;

      //queue
      Queue<TreeNode> qu = new LinkedList<>();
      qu.add(root);

      int ans = 0;

      while(!qu.isEmpty()){

         int sz = qu.size();

         for(int i=1; i<=sz; i++){
            if(qu.peek().left != null) qu.add(qu.peek().left);
            if(qu.peek().right != null) qu.add(qu.peek().right);

            qu.remove();
            ans++;
         }
      }

      return ans;
   }
}
