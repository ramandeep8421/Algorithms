class Solution {
public:
    
    void invert(TreeNode* node){
           
           if(node == NULL)return;

           TreeNode* temp = node->left;
           node->left = node->right;
           node->right = temp;
          
           invert(node->left);
           invert(node->right);

             
    }
 
    TreeNode* invertTree(TreeNode* root) {
       
            invert(root);
            return root;
    }
};
