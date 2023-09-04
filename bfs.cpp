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
 
void bfs(vector<bool>&vis, vector<int>adj[]){
	   queue<int>q;
	   q.push(0);
	   vis[0]=1;
	   while(!q.empty()){
	   	   int node = q.front();
	   	   q.pop();
	   	   cout << node << " ";
	   	   for(auto child: adj[node]){
	   	   	    if(!vis[child]){
	   	   	    	  q.push(child);
	   	   	    	  vis[child] =1;
	   	   	    }
	   	   }
	   }
}
 
int main(){
    init();
    
    int n;
    cin >> n;
    //cout << n;

    vector<pair<int,int>>edges(n-1);

    for(int i=0;i<n-1;i++){
    	   cin >> edges[i].first >> edges[i].second;
    }

    //starts from here

   vector<int>adj[n];
 

   for(auto edge: edges){
   	    adj[edge.first].push_back(edge.second);
   	    adj[edge.first].push_back(edge.second);
   }
  
    vector<bool>vis(n, false);


   bfs(vis, adj);

    return 0;
}
