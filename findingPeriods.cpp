#include <bits/stdc++.h>
using namespace std;

#define int long long
const long long mod = 1e9 + 7;
int p=31;
long long get_hash(int l, int r, const vector<long long> &hash, const vector<long long> &power) {
    long long h = (hash[r + 1] - (power[r - l + 1] * hash[l]) % mod + mod) % mod;
    return h;
}
void pre(int n, vector<int> &pow,vector<int> &hash, string &s)
{
    for(int i=1;i<=n;i++)
    {
        pow[i]=(pow[i-1]*p)%mod;
        pow[i] %= mod;
        hash[i]= ((hash[i-1]*p)%mod + ((s[i-1]-'a'))%mod)%mod;
        hash[i] %= mod;
    }
}
void solve()
{

    string s;
    cin >> s;
    int n = s.size();
    vector<int> pow(n+1,1),hash(n+2,0);
    pre(n,pow,hash,s);
    for(int i=0;i<n;i++)
    {
        int r=0;
        bool fl=true ;
        while(r<n)
        {
            int l = min(i+1,n-r);
            if(get_hash(0,l-1,hash,pow)!=get_hash(r,r+l-1,hash,pow))
            {
                fl=false;
                break;
            }
            r+=l;
        }
        if(fl)
        {
            cout<<i+1<<" ";
        }
    }
    return ;
}

signed main()
{
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int t;
    t = 1;

    while (t--)
        solve();
    return 0;
}
