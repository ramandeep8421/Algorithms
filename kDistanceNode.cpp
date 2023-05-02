struct dist{
   TreeNode* node;
   int distance;
};



class Solution {
public:
    
      vector<int>res;

    unordered_map<TreeNode* , TreeNode*>mp;
    //Function to annotate parent
    void dfs(TreeNode* root, TreeNode* parent){
     
       if(root == NULL)return;
        mp[root] = parent;
        dfs(root->left, root);
        dfs(root->right, root);
    }
    
    //
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        //In case of an empty tree
        if(root == NULL)return {};


        //call the DFS function to annotate the binary tree
        dfs(root,NULL);


        //queue 
        queue<dist>qu;
        qu.push({target,0});


        unordered_map<TreeNode*, bool>vis;
        vis[target]=true;

         while(!qu.empty()){

            dist d = qu.front();
            qu.pop();
            if(d.distance == k){
                  res.push_back(d.node->val);
                  continue;
            }
            if(d.node->left and !vis[d.node->left]){
                 qu.push({d.node->left,d.distance+1});
                 vis[d.node->left]= true;
            }
            if(d.node->right and !vis[d.node->right]){
                  qu.push({d.node->right, d.distance+1});
                  vis[d.node->right] = true;
            }
            if(mp[d.node] and !vis[mp[d.node]]){
                  qu.push({mp[d.node],d.distance+1});
                  vis[mp[d.node]]=true;
            }

        }

        return res;
    }
};
