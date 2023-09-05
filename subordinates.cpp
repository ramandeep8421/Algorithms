/*
      . Always use boolean visited array for avoiding MLE
      . Pass minimum arguments to the function to avoid MLE
      . Pass by reference as much as possible to avoid TLE in some cases
      . Always use unordered_map with custom hash to make the process as fast as possible
*/
 
#include <bits/stdc++.h>
// #include <ext/pb_ds/detail/standard_policies.hpp>
// #include <ext/pb_ds/assoc_container.hpp>
// #include <ext/pb_ds/tree_policy.hpp>
using namespace std;
//using namespace __gnu_pbds;
 
 
#define watch(x)           cout<<(#x)<<"="<<(x)<<'\n'
#define mset(d,val)         memset(d,val,sizeof(d))
#define setp(x)             cout<<fixed<<setprecision(x)
#define loop(i,a,b)         for(int i=(a);i<(b);i++)
#define hunt(i,a,b)         for(int i=(a);i<=(b);i++)
#define lp(i,a,b)           for(int i = a; i >= b; i--)
#define rep(i,n)            for(int i = 0; i < n; i++)
#define int                 long long int 
#define pb                  push_back
#define f                   first
#define s                   second
#define pqueue              priority_queue
#define fbo                 find_by_order
#define ook                 order_of_key
#define ll                  long long
#define ii                  pair<int,int>
#define vi                  vector<int>
#define vii                 vector<ii>
#define ld                  long double 
#define all(x)              begin(x),end(x)
void YES(){cout<<"YES\n";} void NO(){cout<<"NO\n";}
int Bexp(int a,int b){ int ret=1; for (;b;a=a*a,b>>=1) if (b&1) ret=ret*a; return ret; }
ll gcd(ll A , ll B)
{
  if(B == 0)return A;
  return gcd(B , A%B);
}
ll min(ll a , ll b){return a > b ? b : a;}
ll max(ll a , ll b){return a > b ? a : b;}
/*
int mod(a, b) {
  c = a % b
  return (c < 0) ? c + b : c
 
*/
int mod(int a, int b) {
  return (((a % b) + b) % b);
}
#define ordered_set tree<int, null_type,less<int>, rb_tree_tag,tree_order_statistics_node_update>
 
//Always check odd-even using AND and never using MODULO
bool is_odd(int n) {
    return n & 1 != 0;
}
 
//Faster map
struct custom_hash {
    static uint64_t splitmix64(uint64_t x) {
        // http://xorshift.di.unimi.it/splitmix64.c
        x += 0x9e3779b97f4a7c15;
        x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9;
        x = (x ^ (x >> 27)) * 0x94d049bb133111eb;
        return x ^ (x >> 31);
    }
 
    size_t operator()(uint64_t x) const {
        static const uint64_t FIXED_RANDOM = chrono::steady_clock::now().time_since_epoch().count();
        return splitmix64(x + FIXED_RANDOM);
    }
};
//unordered_map<int,int, custom_hash> mp;
 
 
void The_Hawk_returns()
{
#ifndef vjudge
    if (fopen("input.txt", "r"))
    {
        freopen("input.txt", "r", stdin);
        freopen("output.txt", "w", stdout);
    }
#endif
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
}
 
void dfs(int node, int parent, vector<int>adj[], vector<int>&dp){
     for(auto it: adj[node]){
         if(it != parent){
              dfs(it,node,adj,dp);
              dp[node] += dp[it];
         }
     }
}
void solve(int test){
    int n;
    cin >> n;
    vector<int>adj[n];
    for(int i=1;i<=n-1;i++){
          int x;
          cin >> x;
          x--;
          adj[x].pb(i);
          adj[i].pb(x);
    }
 
    vector<int>dp(n,1);
    dfs(0,-1,adj,dp);
    rep(i,n)
      cout << dp[i]-1 << " ";
}
 
int32_t main(){
    
    The_Hawk_returns();
    int t=1;
    //cin >> t;
    for(int test=1;test<=t;test++){
      solve(test);
    } 
    cerr<<"Time:"<<1000*((double)clock())/(double)CLOCKS_PER_SEC<<" ms\n";
} 
