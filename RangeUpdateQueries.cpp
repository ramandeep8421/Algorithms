#include <bits/stdc++.h>
using namespace std;
#define int long long int 
const int MAXN = 200011;
int t[4*MAXN];

// 3 3 5 6 2 1 5 3
// 2 4 -> 5
// 1 2 5 1
// 2 4 -> 6

void build(int a[], int v, int tl, int tr) {
    if (tl == tr) {
        t[v] = a[tl];
    } else {
        int tm = (tl + tr) / 2;
        build(a, v*2, tl, tm);
        build(a, v*2+1, tm+1, tr);
        t[v] = 0;
    }
}

void update(int v, int tl, int tr, int l, int r, int add) {
    if (l > r)
        return;
    if (l == tl && r == tr) {
        t[v] += add;
    } else {
        int tm = (tl + tr) / 2;
        update(v*2, tl, tm, l, min(r, tm), add);
        update(v*2+1, tm+1, tr, max(l, tm+1), r, add);
    }
}


int get(int v, int tl, int tr, int pos) {
    if (tl == tr)
        return t[v];
    int tm = (tl + tr) / 2;
    if (pos <= tm)
        return t[v] + get(v*2, tl, tm, pos);
    else
        return t[v] + get(v*2+1, tm+1, tr, pos);
}

int32_t main() {
	// your code goes here
	int n,q;
	cin >> n >> q;
	
	int x[n];
	
	for(int i=0;i<n;i++)cin >> x[i];
	build(x,1,0,n-1);
	
	while(q--){
	     
	     int t,a,b,u,k;
	     
	     cin >> t;

         
	     if(t == 1){
	          cin >> a >> b >> u;
	          a--;
	          b--;
	          update(1,0,n-1,a,b,u);
	     }else{
	          cin >> k;
	          k--;
	          int ans = get(1,0,n-1,k);
	          cout << ans << "\n";
	     }
	}
}
