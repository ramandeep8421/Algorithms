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


bool isCycle(int node, vector<int>&vis, vector<int>&recStack, stack<int>&st, vector<int>adj[]){

	     vis[node] = recStack[node] = 1;

	     st.push(node);

	     for(auto neighbor: adj[node]){
	     	   if(!vis[neighbor]){ // include it into the cycle
	     	   	    if(isCycle(neighbor, vis, recStack, st, adj)){
	     	   	    	  return true;
	     	   	    }
	     	   }else if(recStack[neighbor]){
	     	   	    // back-edge
	     	   	    st.push(neighbor);
	     	   	    return true;
	     	   }
	     }

	     recStack[node]=0;
	     st.pop();

	     return false;
}

vector<int>extract(stack<int>&st){

	   int node = st.top();

	   vector<int>cycle;

	   cycle.push_back(node);

	   st.pop();

	   while(!st.empty()){
	   	   cycle.push_back(st.top());
           if(st.top() == node){
           	  break;
           }
           st.pop();
	   }

	   return cycle;
}
 
//just detect if there is a cycle or not 
vector<int>roundTrip(int n, vector<int>adj[]){
      
      vector<int>vis(n+1,0);
      vector<int>recStack(n+1,0);
      stack<int>st;

      for(int i=1;i<=n;i++){
      	   if(!vis[i]){ 
                 if(isCycle(i, vis, recStack, st, adj)){
                 	  return extract(st);
                 }
      	   }
      }

      return {};
}

int main(){
   init();
   
   int n,m;
   cin >> n >> m;

   vector<int>adj[n+1];

   for(int i=0;i<m;i++){
   	  int a,b;
   	  cin >> a >> b;
   	  adj[a].push_back(b);
   }

   vector<int>cycle = roundTrip(n, adj);

   if(cycle.size() == 0){
   	  cout << "IMPOSSIBLE\n";
   	  return 0;
   }
  
   reverse(cycle.begin(), cycle.end());
   cout << cycle.size() << "\n";

   for(auto it: cycle)
   	  cout << it << " ";
    
}
