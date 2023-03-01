#include<bits/stdc++.h>
using namespace std;

int dp[500][500];

int min(int x, int y, int z){
    return min(x,min(y,z));
}

int editDistance(string X, string Y, int m, int n){

       //If the first string is exhausted
       // then append all characters of second string
       if(m == 0)return dp[m][n] = n;

       // If the second string is exhausted 
       // then append all characters of first string
       if(n == 0)return dp[m][n] = m;
  
       //Incase the result is already computed
       if(dp[m][n] != -1)
           return dp[m][n];

       //If the last characters match then
       // move to the right by one
       if(X[m-1] == Y[n-1])dp[m][n] = editDistance(X,Y,m-1,n-1);

       //Otherwise explore all three cases 
       // and take maximum of the three
       else
        return dp[m][n] = 1 + min(editDistance(X,Y,m,n-1),  //insert
                       editDistance(X,Y,m-1,n),  //Delete
                       editDistance(X,Y,m-1,n-1) // Replace
                      );
    
}

int main(){
       string X,Y;
       cin >> X >> Y;
       for(int i=0;i<500;i++)
          for(int j=0;j<500;j++)
               dp[i][j] = -1;

       cout << editDistance(X,Y,X.length(),Y.length());
}
