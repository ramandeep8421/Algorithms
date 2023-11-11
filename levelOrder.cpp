/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
          
          queue<TreeNode*>qu;
          qu.push(root);

          vector<vector<int>>vec;

          while(!qu.empty()){
                
                 int sz = qu.size();
                 vector<int>v;
 
                   for(int i=1;i<=sz;i++){
                        TreeNode* node = qu.front();
                        if(node){
                             v.push_back(node->val);
                             if(node->left)
                                qu.push(node->left);
                             if(node->right)
                                 qu.push(node->right);
                        }
                        qu.pop();
                  }

                        if(v.size() > 0)
                        vec.push_back(v);

          }

          return vec;
    }
};
