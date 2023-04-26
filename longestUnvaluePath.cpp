#include <bits/stdc++.h>
using namespace std;

struct TreeNode
{
   int data;
   TreeNode *left;
   TreeNode* right;
   TreeNode(){ data(0), left(NULL), right(NULL)}
};


class Solution {
public:
     int ans;

     //function to find the longest 
     // univalue path
     int longestUnivaluePath(TreeNode* root){
         ans = 0;
         directionalLength(root);
         return ans;
     }
   
     //Function to find the longestUnivaluePath
     int directionalLength(TreeNode* root){

        //if we have empty tree, then return 0
        if(root == NULL)return 0;
 
        //find the directionalLength for left subtree
        int left = directionalLength(root->left);

        //find the directionalLength for right subtree
        int right = directionalLength(root->right);

        //integers to store the length values
        int dirRight = 0, dirLeft = 0;
        
        //check for the longest univalue path 
        // in the left subtree
        if(root->left != NULL and root->left->data == root->val){
            dirLeft += (left + 1);
        }

        //check for the longest univalue path in the right subtree
        if(root->right != NULL and root->right->data == root->val){
            dirRight += (right + 1);
        }
       
        // find the max of the ans with the sum of univalue path 
        ans = max(ans, dirLeft + dirRight);
       
        //return the max of left and right longest
        // univalue path
        return max(dirLeft, dirRight);

     }
};
