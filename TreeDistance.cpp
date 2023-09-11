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


pair<int,int>bfs(int node, int n, vector<int>adj[]){
	   queue<pair<int,int>>q;
	   q.push({node,0});

	   vector<bool>vis(n+1, false);

	   vis[node]=true;

	   pair<int,int>u;

	   while(!q.empty()){
	   	     u = q.front();
	   	     q.pop();

	   	     for(auto child: adj[u.first]){
	   	     	   if(!vis[child]){ 
                       q.push({child,u.second+1});
                       vis[child]=true;
	   	     	   }
	   	     }

	   }

	   return u;
}


void dfs(int par, int node, int d, int c, vector<int>adj[], vector<vector<int>>&dp){
	    dp[node][c] = d;
	    for(auto child: adj[node]){
	    	  if(child != par){
	    	  	  dfs(node, child, d+1, c, adj, dp);
	    	  }
	    }
}

int main(){
    init();

    int n;
    cin >> n;

    vector<int>adj[n+1];

    for(int i=1;i<n;i++){
    	  int a,b;
    	  cin >> a >> b;
    	  adj[a].push_back(b);
    	  adj[b].push_back(a);
    }
  
     pair<int,int>p = bfs(1,n,adj);

     pair<int,int>pp = bfs(p.first, n, adj);
   


     vector<vector<int>>dp(n+1, vector<int>(2,0));

     dfs(0,p.first, 0, 0, adj, dp);

     dfs(0,pp.first,0,1,adj,dp);

     for(int i=1;i<=n;i++)
     	   cout << max(dp[i][0],dp[i][1]) << " ";

    return 0;
}
