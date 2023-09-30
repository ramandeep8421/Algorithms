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
 
const int MAXN = 200011;
vector<int>adj[MAXN];
vector<int>sub(MAXN,1);
 
int n, t[4*MAXN];
int timer = 0;
int start[MAXN], value[MAXN], arr[MAXN];
 
void build(int v, int tl, int tr) {
    if (tl == tr) {
        t[v] = arr[tl];
        return;
    }
        int tm = (tl + tr) / 2;
        build(v*2, tl, tm);
        build(v*2+1, tm+1, tr);
        t[v] = t[v*2] + t[v*2+1];
    
}
 

void update(int v, int tl, int tr, int pos, int new_val) {
    if (tl == tr) {
        t[v] = new_val;
    } else {
        int tm = (tl + tr) / 2;
        if (pos <= tm)
            update(v*2, tl, tm, pos, new_val);
        else
            update(v*2+1, tm+1, tr, pos, new_val);
        t[v] = t[v*2] + t[v*2+1];
    }
}
int sum(int v, int tl, int tr, int l, int r) {
    if (l > r) 
        return 0;
    if (l == tl && r == tr) {
        return t[v];
    }
    int tm = (tl + tr) / 2;
    return sum(v*2, tl, tm, l, min(r, tm))
           + sum(v*2+1, tm+1, tr, max(l, tm+1), r);
}
 
 
 
void dfs(int node, int par){
	  // cout << node << " ";
	  start[node] = ++timer;
	  arr[start[node]] = value[node];
	  for(auto child: adj[node]){
	  	   //cout << child << " " << node << "\n";
	  	   if(child != par){
	  	   	  //cout << child << "\n";
	  	   	  dfs(child, node);
	  	   	 // cout << node << " " << child << "\n";
	  	   	  sub[node] += sub[child];
	  	   }
	  }
	  
}
 
void solve(){
      int q;
      cin >> n >> q;
      
      for(int i=1;i<=n;i++)cin >> value[i];
 
       
 
      for(int i = 1;i<n;i++){
      	  int a,b;
      	  cin >> a >> b;
      	  //cout << a << " " << b << "\n";
      	  adj[a].push_back(b);
      	  adj[b].push_back(a);
      }
    
      dfs(1,-1);
 
 
   
 
      // build the segment tree over the given euler tour tree
      build(1,1,n);
 
     
      
  
   //    // cout << "\n";
   //    for(int i=0;i<n;i++)
   //    	  cout << sub[i] << " ";
 
   // cout << "\n";

   //   for(int i=0;i<n;i++)
   //   	 cout << start[i] << " ";

   //   cout << "\n";

   //   for(int i=0;i<n;i++)
   //   	  cout << euler_tour[i] << " ";

   //   cout << "\n";
   
      while(q--){
      	   int t;
      	   cin >> t;
      	   if(t == 1){
               int s,x;
               cin >> s >> x;
               //s--;
               // cout << start[s]<<"\n";
               // cout << value[start[s]-1] << "\n";
               update(1,1,n,start[s],x);
               arr[start[s]] = x;
      	   }else{
               int s;
               cin >> s;
               //s--;

               //cout << start[s]-1 << " " << start[s]+ sub[s]-2 << "\n";
                
              cout << sum(1,1,n,start[s], start[s] + sub[s] - 1) << "\n";
               
      	   }
      }
      
 
}
 
int32_t main(){
     init();
     int t=1;
     //cin >> t;
     while(t--){
     	  solve();
     }
}
