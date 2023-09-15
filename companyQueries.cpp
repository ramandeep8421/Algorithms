#include<bits/stdc++.h>
using namespace std;
#define fast_io ios_base::sync_with_stdio(false);cin.tie(NULL)
#define int long long int 
void init() {
fast_io;
#ifndef ONLINE_JUDGE
freopen("input.txt", "r", stdin);
freopen("output.txt", "w", stdout);
#endif // ONLINE_JUDGE
}

int MAXN = 200011;
int M = 20;

vector<vector<int>>up(MAXN, vector<int>(M,0));
vector<int>level(MAXN,0);

void dfs(int node, int par, vector<int>adj[], int lvl){
	   up[node][0]=par;
	   level[node] = lvl;

	   for(auto child: adj[node]){
	   	    if(child != par){
	   	    	  dfs(child, node, adj, lvl+1);
	   	    }
	   }
}


void preprocess(){

	  for(int i=1;i<MAXN;i++){
	  	  for(int j=1;j<M;j++){
	  	  	  if(up[i][j-1] != -1){
                  int par = up[i][j-1];
                  up[i][j] = up[par][j-1];
	  	  	  }
	  	  	  
	  	  }
	  }
}

 
int32_t main(){
    init();
    
     int n,q;
     cin >> n >> q;
     
     vector<int>adj[n+1];

     for(int i=2;i<=n;i++){
     	  int a;
     	  cin >> a;
          adj[i].push_back(a);
          adj[a].push_back(i);
     }

     dfs(1,-1,adj,0);
     preprocess();

     while(q--){
          int x,k;
          cin >> x >> k;

          if(level[x] < k){
          	  cout << -1 << "\n";
          	  continue;
          }

          while(k){
          	  int i = log2(k);
          	  x = up[x][i];
          	   if(x == -1)break;
          	  k -= (1 << i);
          }

          cout << x << "\n";
     }

}
