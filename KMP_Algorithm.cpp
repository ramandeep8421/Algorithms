#include<bits/stdc++.h>
using namespace std;

void preprocessPiTable(string pat, vector<int>&pi){
 
      int m = pat.length();
 
      int len = 0;
 
      pi[0] = 0;
 
      int i = 1;
 
      while(i < m){
 
          if(pat[i] == pat[len]){
               len++;
               pi[i]=len;
               i++;
          }else{
         
                if(len != 0){
                    len = pi[len-1];
                }else{
                    pi[i] = 0;
                    i++;
                }
          }
      }
}
 
int KMPSearch(string txt, string pat){
      int cnt = 0;
      
      int n = txt.length();
      int m = pat.length();
 
      vector<int>pi;
 
      pi.resize(m);
 
      preprocessPiTable(pat,pi);
 
      int i=0; // pointer for the text
      int j=0; // pointer for the pattern
 
      while(n-i >= m-j){
 
            if(txt[i] == pat[j]){
               i++;
               j++;
            } 
 
            if(j == m){
                //cout << "Pattern matched at " << i-j << "\n";
                cnt++;
                j = pi[j-1];
            }
            else if(i < n and pat[j] != txt[i]){
                 if(j != 0){
                    j = pi[j-1];
                 }else
                   i = i + 1;
            }
      }
 
      return cnt;
}
int main(){
	string txt, pat;
	cin >>txt >> pat;
	cout << KMPSearch(txt,pat) << "\n";
}
