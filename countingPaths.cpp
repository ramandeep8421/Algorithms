#include<bits/stdc++.h>
using namespace std;
#define fast_io ios_base::sync_with_stdio(false);cin.tie(NULL)
void init() {
fast_io;
#ifndef ONLINE_JUDGE
freopen("input.txt", "r", stdin);
freopen("output.txt", "w", stdout);
#endif // ONLINE_JUDGE
}

const int maxN = 2e5+1;
const int logN = 20;

int N, M, a, b, sub[maxN], p[maxN][logN];
int timer, in[maxN], out[maxN];
vector<int> G[maxN];

void dfs1(int u = 1, int par = 1){
    in[u] = ++timer;
    p[u][0] = par;
    for(int i = 1; i < logN; i++)
        p[u][i] = p[p[u][i-1]][i-1];
    for(int v : G[u])
        if(v != par)
            dfs1(v, u);
    out[u] = ++timer;
}

void dfs2(int u = 1){
    for(int v : G[u]){
        if(v != p[u][0]){
            dfs2(v);
            sub[u] += sub[v];
        }
    }
}

bool ancestor(int u, int v){
    return in[u] <= in[v] && out[u] >= out[v];
}

int lca(int u, int v){
    if(ancestor(u, v))  return u;
    if(ancestor(v, u))  return v;
    for(int i = logN-1; i >= 0; i--)
        if(!ancestor(p[u][i], v))
            u = p[u][i];
    return p[u][0];
}

void solve(){
      int n,m;
     cin >> n >> m;

     for(int i=1;i<n;i++){
     	  int a,b;
     	  cin >> a >> b;
     	  G[a].push_back(b);
     	  G[b].push_back(a);
     }
   
      dfs1();

     for(int i = 0; i < m; i++){
        cin >> a >> b;
        int l = lca(a, b);
        sub[a]++; sub[b]++;
        sub[l]--;
        if(l != -1)
            sub[p[l][0]]--;
    }

     dfs2(1);

     for(int i=1;i<=n;i++)
     	  cout << sub[i] << " ";

}

int main(){
     init();
     int t=1;
     //cin >> t;
     while(t--){
     	  solve();
     }
}
