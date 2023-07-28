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

const int MOD = 1e9 + 7;
 
int main(){

	init();
	int n;
	cin >> n;

	char board[n][n];

	for(int i=0;i<n;i++){
		 for(int j=0;j<n;j++){
		 	  cin >> board[i][j];
		 }
	}
   
    if(board[0][0] == '*' || board[n-1][n-1] == '*'){
    	  cout << 0 << "\n";
    	  return 0;
    }
	vector<vector<int>>dp(n,vector<int>(n,0));

	dp[0][0] = 1;

	for(int i=0;i<n;i++){
		  for(int j=0;j<n;j++){
		  	   if(i-1 >= 0 and board[i][j] != '*'){
		  	   	    dp[i][j] += (dp[i-1][j]);
		  	   	    dp[i][j] %= MOD;
		  	   }
		  	   if(j-1 >= 0 and board[i][j] != '*'){
		  	   	     dp[i][j] += dp[i][j-1];
		  	   	     dp[i][j] %= MOD;
		  	   }
		  }
	}


	cout << dp[n-1][n-1] << "\n";
    
    
}
