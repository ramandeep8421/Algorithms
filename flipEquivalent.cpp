struct TreeNode{
   int val;
   TreeNode* left;
   TreeNode* right;
};

class Solution {
public:
     bool flipEquivalent(TreeNode* root1, TreeNode *root2){
          if(root1 == root2)
               return true;

          if(root1 == null || root2 == null || root1.val != root2.val)
              return false;

          return (flipEquivalent(root1.left, root2.left) and flipEquivalent(root1.right, root2.right)) ||
           (flipEquivalent(root1.left, root2.right) and flipEquivalent(root1.right, root2.left));
     }
};
