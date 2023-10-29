class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
         if(p == NULL and q== NULL)return true;

         if(p == NULL and q != NULL || p != NULL and q == NULL ||q->val != p->val)return false; 
         

        if((isSameTree(p->left,q->left) == false) || (isSameTree(p->right, q->right) == false))return false;

        return true;
    }
};
