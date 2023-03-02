#include<bits/stdc++.h>
using namespace std;

int dp[500][500];

int min(int x, int y, int z){
    return min(x,min(y,z));
}

 int knapsackRec(int wt[], int val[], int W, int n, int** dp){
   // base case
   if(n == 0 || W == 0)
    return 0;
   
   // when the item is not fittable in the given capacity
   if(W - wt[n-1] < 0)
    return dp[n-1][W] = knapsackRec(wt,val,W,n-1,dp);

   // if the solution of the problem is already evaluated
   if(dp[n-1][W] != -1){
     return dp[n-1][W];
   }
   
   //if fittable then do the exaustive search for both options and take max
   //  of them...
   return dp[n-1][W] = max(val[n-1] + knapsackRec(wt,val,W-wt[n-1],n-1,dp) , knapsackRec(wt,val,W,n-1,dp));
}

int knapsack(int wt[], int val[], int W, int n){

    // use a double pointer to declare the table dynamically
    int** dp;
    dp = new int*[n];

    //loop to create table dynamically
    for(int i=0;i<n;i++)
      dp[i] = new int[W+1];

    //Iterate to initially fill the table with -1
    // memset does not work here WHY?..
    for(int i=0;i<n;i++)
      for(int j=0;j<W+1;j++)
        dp[i][j]=-1;

    return knapsackRec(wt,val,W,n,dp);
}


int main(){
      int W,n;
      int wt[n],val[n];
      for(int i=0;i<n;i++)cin >> wt[i];
      for(int i=0;i<n;i++)cin >> val[i];
      cout << knapsack(wt,val,W,n) << "\n";
}
