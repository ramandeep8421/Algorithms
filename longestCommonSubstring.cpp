#include<bits/stdc++.h>
using namespace std;


void lcs(string X, string Y, int m, int n){

     int dp[m+1][n+1];
     int result = 0;

     for(int i=0;i<=m;i++){
         for(int j=0;j<=n;j++){
              if(i == 0 || j == 0)
                   dp[i][j]=0;
               else if(X[i-1] == Y[j-1]){
                  dp[i][j] = dp[(i-1)][j-1]+1;
                  result = max(result, dp[i][j]);
               }else{
                   dp[i][j]=0;
               }
         }
     }
     
     cout << result << "\n";
}

int main(){
     string x,y;
     cin >> x >> y;
     lcs(x,y,x.length(),y.length());
}
