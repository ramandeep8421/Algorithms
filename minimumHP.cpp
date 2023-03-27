#include<bits/stdc++.h>
using namespace std;


class DungeonGame{

  public:

     int calculateMinimumHP(vector<vector<int>>&dungeon){
         //Calculate the dimensions of the dungeon
         int n = dungeon.size();
         int m = dungeon[0].size();


         //Declare a dp array for the corresponding dungeon
         vector<vector<int>>dp(n+1,vector<int>(m+1,INT_MAX));

          //Initialize the bottom right cell
         dp[n-1][m] = dp[n][m-1] = 1;

            //Iterating over the dp and fill it 
         for(int i=n-1;i>=0;i--){
             for(int j=m-1;j>=0;j--){
                  int value = min(dp[i+1][j], dp[i][j+1]) -dungeon[i][j];    
                  dp[i][j] = max(1,value);
             }
         }
        
         //The first position in the dp array contains 
        // the required answer !! 
         return dp[0][0];
 
     }
};
