#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
      //variable to store the final answer
    int ans=0;

    //direction vectors
    vector<int> dr={-1,0,1,0};
    vector<int> dc={0,1,0,-1};

     //fundtion to check for the visited cells
    bool check(vector<vector<int>> &grid, vector<vector<bool>> &vis){
        int n= grid.size();
        int m=grid[0].size();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==0 && vis[i][j]==false) return false;
            }
        }
        return true;
    }

      //dfs function to perform the traversal
    void dfs(int i, int j, int x, int y, vector<vector<int>> &grid, vector<vector<bool>> &vis){
        int n= grid.size();
        int m=grid[0].size();

        if(i==x && j==y){
            vis[i][j]=true;
            if(check(grid,vis)) ans++;
            vis[i][j]=false;
            return;
        }
        vis[i][j]=true;
        for(int k=0; k<4; k++){
            int newr= i+dr[k], newc= j+dc[k];
            if(newr<0 || newr>=n || newc<0 || newc>=m || grid[newr][newc]==-1 || vis[newr][newc]) continue;
            dfs(newr,newc,x,y,grid,vis);
        }
        vis[i][j]=false;
    }

    
    //function to count the unique paths
    int uniquePathsIII(vector<vector<int>>& grid) {
        int n= grid.size();
        int m=grid[0].size();
        vector<vector<bool>> vis(n, vector<bool>(m,false));

        int sr,sc,er,ec;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    sr=i, sc=j;
                }
                else if(grid[i][j]==2){
                    er=i, ec=j;
                }
            }
        }
        dfs(sr,sc,er,ec,grid,vis);
        return ans;
    }

};
