#include<bits/stdc++.h>
using namespace std;

int dp[1011][1011];

int lcs(string X, string Y, int n, int m){

      //base case
      if(n == 0 || m == 0)return 0;

      //If the last characters are matching 
      // lcs increases by 1
      if(X[n-1] == Y[m-1])
        return dp[n][m] = 1 + lcs(X,Y,n-1,m-1);

      //If the result for the indices n and m 
      // are already memoized then return the result
      if(dp[n][m] != -1)
          return dp[n][m];

      //Take the maximum of the result 
      // Obtained from the two cases
      //case-1: lcs of X[0..n-1] and Y[0...m]
      //case-2: lcs of Y[0...m-1] and Y[0...n]
      return dp[n][m] = max(lcs(X,Y,n-1,m),lcs(X,Y,n,m-1));
}

int main(){
       string X,Y;
       cin >> X >> Y;
       cout << lcs(X,Y,X.length(),Y.length());
}
