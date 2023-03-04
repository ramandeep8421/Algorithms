#include<bits/stdc++.h>
using namespace std;

int coinChange(int idx, vector<int>&coins, int amount){
      //If the number of coins are exhausted
      if(idx  >= coins.size() || amount <= 0)return 0;

      int res = -1;
      //If the value of coin at current location 
      //is greater than amount
      if(coins[idx] > amount){
         //Case where we are not taking the current coin
          int doNotTakeCoin = coinChange(idx+1,coins,amount);
          res = doNotTakeCoin;
      }  else{
           //Two cases are there
           //case-1: where we take the coin
           //case-2: where we do not take the coin
           int takeCoin = 1 + coinChange(idx,coins,amount-coins[idx]);
           int doNotTakeCoin = 0 + coinChange(idx+1,coins,amount);
           res = min(takeCoin,doNotTakeCoin);
      }

      return res;
}

int main(){
      int n,amount;
      cin >> n >> amount;
      vector<int>coins(n);
      for(int i=0;i<n;i++)cin >> coins[i];
      cout << coinChange(0,coins,amount) << "\n";
}
