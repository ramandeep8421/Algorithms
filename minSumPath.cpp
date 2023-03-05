#include<bits/stdc++.h>
using namespace std;

int minPathSum(int i, int j, vector<vector<int>>&grid, vector<vector<int>>&dp){

     //Base case-1
     if(i == 0 and j == 0)return grid[i][j];
 
     //Base case-2
     if(i < 0 || j < 0)return 10000007;

     //Memoization case
      if(dp[i][j] != -1)return dp[i][j];

     //recur for the path in 0 to i-1
     int up = grid[i][j] + minPathSum(i-1,j,grid,dp);

     //recur for the path in 0 to j-1
     int left = grid[i][j] + minPathSum(i,j-1,grid,dp);
    
     //return the result
     return dp[i][j] = min(up,left);

}

int main(){
       int n,m;
       cin >> n >> m;
       vector<vector<int>>dp(n,vector<int>(m,-1));
       cout << minPathSum(n-1,m-1,grid,dp) << "\n";
}
