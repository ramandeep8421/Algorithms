#include <bits/stdc++.h>
using namespace std;

class Solution{

    public:
         
         //Function to check for a valid parenthesis string
         bool isValidParenthesis(string s){
              //size of the string s
              int n = s.length();

              //Declare a stack 
              stack<int>st;

              //Iterate over the string
              for(int i=0;i<n;i++){
                 if(s[i] == '{' || s[i] == '[' || s[i] == '('){
                     st.push(s[i]);
                 }
                 else {
                  if(st.empty() or (s[i] != ')' and st.top() == '(') or (s[i] != ']' and st.top() == '[') or (st.top() == '{' and s[i] != '}'))
                      return false;
                   
                   st.pop();
                 }
              }

              return st.empty(); 
         }
}
