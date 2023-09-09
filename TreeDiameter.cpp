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

// find the distance of each node from root node 1
// sort the distances 
// sum the max 2 distances

int fNode;

pair<int,int>bfs(int node, int n, vector<int>adj[]){
	   queue<pair<int,int>>q;
	   q.push({node, 0});

	   vector<bool>vis(n+1, false);

	   vis[node] = true;

	   pair<int,int>lastVis;

	   while(!q.empty()){
            
              lastVis = q.front();
              q.pop();

              for(auto child: adj[lastVis.first]){
              	    if(!vis[child]){
              	    	   q.push({child, lastVis.second + 1});
              	    	   vis[child] = true;
              	    }
              }
	   }


       return lastVis;


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
    
    pair<int,int>p = bfs(1, n,adj);
    //cout << p.first <<"\n";
    pair<int,int>pp = bfs(p.first, n, adj);



    cout<< pp.second;

    return 0;
}
