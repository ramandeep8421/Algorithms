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
     int countNodes(TreeNode* root){
         //Empty tree
         if(root == NULL)return 0;

         //queue
         queue<TreeNode*>qu;

         qu.push(root);

         int ans = 0;

         while(!qu.empty()){

             int sz= qu.size();

             for(int i=1;i<=sz;i++){
                 if(qu.front()->left)qu.push(qu.front()->left);
                 if(qu.front()->right)qu.push(qu.front()->right);

                 qu.pop();
                 ans++;
             }
         }

         return ans;
     }
};
