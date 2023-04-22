class Solution {
public:
    TreeNode* ans;

    bool recursionTree(TreeNode* currNode, TreeNode *p, TreeNode* q){
           if(currNode == NULL)return NULL;


         int left = recursionTree(currNode->left,p,q) ? 1 : 0;
         int right = recursionTree(currNode->right,p,q) ? 1 :0;

          int mid = (currNode == p || currNode == q) ? 1 : 0;


         if(mid + left + right >= 2)ans = currNode;


         return (mid + left + right > 0);

    }

    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
         recursionTree(root,p,q);
         return ans;
    }
};
