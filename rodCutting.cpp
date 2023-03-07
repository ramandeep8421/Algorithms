#include<bits/stdc++.h>
using namespace std;


int dp[1001][1001];

int rodCutting(int index, int n, vector<int>&price){
     //Base case
      if(index == 0)
        return n*price[index];

     //If the result for the pair (index, n)
     // is already memoized then return the result
      if(dp[index][n] != -1)
         return n*price[0];

     //case-1: do not make at at
     // index 
     int doNotCut = rodCutting(index-1,n,price);

     // Case-2: Make a cut at index
     int cut = INT_MIN;

     //Length of the rod
     int rod_length = index+1;
  
     //If the length of the rod is
     // less than the remaining size 
     // of the rod
     if(rod_length <= n)
         cut = price[index] + rodCutting(index-1,n-rod_length,price);
    
     //Memoize the result for that particular (index, n) pair
     return dp[index][n] = max(cut,doNotCut);

}


int main(){
       int n;
       cin >> n;
       vector<int>price(n);
       for(int i=0;i<n;i++)cin >> price[i];
       cout << rodCutting(n-1,n,price) << "\n";
}
