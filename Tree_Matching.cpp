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

int ans = 0;
int MAX = 200005;

bool done[200005];

void dfs(int pre, int node, vector<int>adj[]){
      for(auto child: adj[node]){
      	   if(child != pre){
      	   	    dfs(node, child, adj);
      	   	    if(!done[child] and !done[node])done[child] = done[node] = 1, ans++;
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

    memset(done,0,sizeof(done));

    dfs(0,1,adj);

    cout << ans;
    
    return 0;
}
