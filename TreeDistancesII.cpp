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


void dfs(int par, int node, int depth, vector<int>adj[], vector<int>&dp, vector<int>&ans){
           ans[1] += depth;

           for(auto child: adj[node]){
           	    if(child != par){
           	    	   dfs(node, child, depth+1,adj, dp, ans);
           	    	   dp[node] += dp[child];
           	    }
           }
}

void dfs2(int par, int node, int n,vector<int>adj[],vector<int>&dp, vector<int>&ans){
	     for(auto child: adj[node]){
	     	   if(child != par){
	     	   	    ans[child] = ans[node] + (n - 2*(dp[child]));
	     	   	   dfs2(node, child,n, adj,dp, ans);

	     	   }
	     }
}
int32_t main(){
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

    vector<int>dp(n+1,1);
    vector<int>ans(n+1,0);
   
     dfs(0,1,0,adj,dp, ans);
     dfs2(0,1,n,adj,dp,ans);

     for(int i=1;i<=n;i++)
     	  cout << ans[i] << " ";


}
