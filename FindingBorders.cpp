#include<bits/stdc++.h>
using namespace std;


vector<int> preprocessPiTable(string pat){
     int n = pat.length();
     vector<int>pi;
     pi.resize(n);
     int len = 0;
     pi[0]=0;

     int i=1;
    
     while(i < n){
         if(pat[i] == pat[len]){
              len++;
              pi[i]=len;
              i++;
         }else{
               if(len != 0){
                  len = pi[len-1];
               }else{
                   pi[i]=0;
                   i++;
               }
         }
     }

     return pi;

}

 
int main(){
	string s;
    cin >> s;
    vector<int>pi = preprocessPiTable(s);
    vector<int>res;
    int j = pi[pi.size()-1];
    while(j > 0){
          res.push_back(j);
          j = pi[j-1];
    }

    sort(res.begin(),res.end());
    for(auto it: res)
           cout << it << " ";
}
