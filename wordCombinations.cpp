#include<bits/stdc++.h>
using namespace std;



int trie[5000005][26];
bool isEnd[5000005];
int counter = 0; 
int dp[5000005];
const int MOD = 1e9 + 7;
 
string s;
 
//Function to insert a word in trie
void insert(string s){
    int curr = 0;
    for(auto i: s){
          if(!trie[curr][i-'a'])trie[curr][i-'a'] = ++counter;
          curr = trie[curr][i-'a'];
    }
    isEnd[curr]=1;
}

//Function to search for a word in a trie
int wordCombinations(int index){
      if(index == (int)s.length())return dp[s.length()] =  1;

      int node = 0;
      int ans=0;

      for(int i=index;i<(int)s.length();i++){
            if(! trie[node][s[i]-'a'])return dp[index] = ans;
            node = trie[node][s[i]-'a'];
            if(isEnd[node]){
                 if(dp[i+1] != -1)ans = (ans + dp[i+1])%MOD;
                 else ans = (ans + wordCombinations(i+1))%MOD;
            }
      }

      return dp[index] = ans;
}


int main(){
	int k;
    cin >> s >> k;
    
    while(k--){
         string str;
         cin >> str;
         insert(str);
        
     }
    
    memset(dp,-1,sizeof dp);
    
    cout << wordCombinations(0) << "\n";
}
