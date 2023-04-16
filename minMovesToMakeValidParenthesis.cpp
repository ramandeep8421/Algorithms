#include <bits/stdc++.h>
using namespace std;

class Solution{

    public:

          int minAddToMakeValid(string s){
               int n = s.length();
                int ans= 0 , balance = 0;

                  for(int i=0;i<n;i++){
                      balance += (s[i] == '(') ? 1 : -1;
                      if(balance == -1){
                          ans++;
                          balance++;
                      }
                }

                return ans + balance;
          }
}
