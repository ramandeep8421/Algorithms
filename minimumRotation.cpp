#include<bits/stdc++.h>
using namespace std;


int main(){
    string s;
    cin>>s;
    s+=s;
    int n = s.size();
    int i = 0;
    int ans = 0;
    while (i < n/2) {
        ans = i;
        int k = i, j = i + 1;
        while (j < n && s[j] >= s[k]) {
            if (s[j] == s[k]) k++;
            if (s[j] > s[k] ) k = i;
            j++;
        }
        while(i <= k) i += j - k;
    }
    cout<<s.substr(ans,n/2);
}
