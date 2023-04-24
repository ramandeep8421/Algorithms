#include <bits/stdc++.h>
using namespace std;


//Definition for treeNode
struct TreeNode{
   int val;
   TreeNode*left;
   TreeNode*right;
   TreeNode(int x): val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    pair<int, int> solve(TreeNode* root)
    {

        if(root==NULL)
        return {0,0};

         auto p1=solve(root->left);
        auto p2=solve(root->right);

        pair<int, int> p;
        p.first=root->val+p1.second+p2.second;
         p.second=max(p1.first, p1.second)+max(p2.first, p2.second);

         return p;
       
    }
    int rob(TreeNode* root) {
       pair<int,int>p = solve(root);

       return max(p.first,p.second);
    }
};
