#include <bits/stdc++.h>
using namespace std;
 

class Solution {
public:
     string removeDuplicates(string s, int k){
           
           stack<pair<int,int>>st;

           int count =1;

           int n = s.length();

           for(int i=0;i<n;i++){

               if(st.empty()){
                  st.push({s[i],count});
                  continue;
               }
               else if(st.top().first == s[i]){
                  st.top().second++;

                  if(st.top().second == k){
                      st.pop();
                  }
               }
               else{
                  count = 1;
                  st.push({s[i],count});
               }
           }

           string ans = "";

           while(!st.empty()){
               while(st.top().second){
                    ans += st.top().first;
                    st.top().second--;
               }
               st.pop();
           }

           reverse(ans.begin(),ans.end());
           return ans;
     }
};
