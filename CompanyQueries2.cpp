#include <bits/stdc++.h>
//#include <ext/pb_ds/assoc_container.hpp>
//#include <ext/pb_ds/trie_policy.hpp>
 
using namespace std;
//using namespace __gnu_pbds;
 
 
#define watch(x)           cout<<(#x)<<"="<<(x)<<'\n'
#define mset(d,val)         memset(d,val,sizeof(d))
#define setp(x)             cout<<fixed<<setprecision(x)
#define loop(i,a,b)         for(int i=(a);i<(b);i++)
#define hunt(i,a,b)         for(int i=(a);i<=(b);i++)
#define lp(i,a,b)           for(int i = a; i >= b; i--)
#define rep(i,n)            for(int i = 0; i < n; i++)
// #define int                 long long int 
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
ll Bexp(ll a,int b){ ll ret=1; for (;b;a=a*a,b>>=1) if (b&1) ret=ret*a; return ret; }
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
}
*/
int mod(int a, int b) {
  return (((a % b) + b) % b);
}
//typedef tree<int, null_type, less<int>, rb_tree_tag,
  //           tree_order_statistics_node_update>
   // indexed_set;
//Always check odd-even using AND and never using MODULO
bool is_odd(int n) {
    return n & 1 != 0;
}
 
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
 
const int MAXN = 200111;
const int N = 20;
vector<int>tree[MAXN];
int spt[MAXN][N],level[MAXN];
 
void dfs(int node, int par, int lvl){
      level[node]=lvl;
      spt[node][0]=par;
      for(auto child: tree[node]){
         if(child != par){
             dfs(child,node,lvl+1);
         }
      }
}
 
 
void init(){
     dfs(1,-1,0);
     for(int i=1;i<MAXN;i++){
         for(int j=1;j<N;j++){
             if(spt[i][j-1] != -1){
                 int par = spt[i][j-1];
                 spt[i][j] = spt[par][j-1];
             }
         }
     }
}
 
int LCA(int a, int b){
     if(level[b] < level[a])swap(a,b);
     int d = level[b]-level[a];
 
     while(d){
         int i = log2(d);
         b = spt[b][i];
         d -= (1 << i);
     }
 
     if(a == b)return a;
 
     for(int i=N-1;i>=0;i--){
        if(spt[a][i] != -1 && (spt[a][i] != spt[b][i])){
             a = spt[a][i];
             b = spt[b][i];
        }
     }
 
     return spt[a][0];
}
void solve(){
    int n ,q;
    cin >> n >> q;
    for(int i=2;i<=n;i++){
         int e;
         cin >> e;
         tree[e].pb(i);
         tree[i].pb(e);
    }
    init();
    while(q--){
        int a,b;
        cin >> a >> b;
        cout << LCA(a,b) << "\n";
    }
} 
 
 
int32_t main() {
    
    The_Hawk_returns();
   // init();
    int t=1;
    //cin >> t;
    for(int test=1;test<=t;test++){
      solve();
    }
} 
