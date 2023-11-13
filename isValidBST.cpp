class Solution {
public:

    bool check(TreeNode* node, long long lb, long long ub){
           if(node == NULL)return true;

           if(node->val >= ub || node->val <= lb)return false;

           return check(node->left, lb, node->val) and check(node->right, node->val, ub);

    }
    bool isValidBST(TreeNode* root) {
          return check(root, LLONG_MIN, LLONG_MAX);
    }
};
