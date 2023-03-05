#include<bits/stdc++.h>
using namespace std;

// Taking the matrix as globally
int dp[2000][2000];
 
// Check if possible subset with
// given sum is possible or not
int subsetSum(vector<int>&a, int n, int sum)
{
     
    // If the sum is zero it means
    // we got our expected sum
    if (sum == 0)
        return 1;
         
    if (n <= 0)
        return 0;
   
    // If the value is not -1 it means it
    // already call the function
    // with the same value.
    // it will save our from the repetition.
    if (dp[n - 1][sum] != -1)
        return dp[n - 1][sum];
   
    // if the value of a[n-1] is
    // greater than the sum.
    // we call for the next value
    if (a[n - 1] > sum)
        return dp[n - 1][sum] = subsetSum(a, n - 1, sum);
    else
    {
         
        // Here we do two calls because we
        // don't know which value is
        // full-fill our criteria
        // that's why we doing two calls
        return dp[n - 1][sum] = subsetSum(a, n - 1, sum) ||
                       subsetSum(a, n - 1, sum - a[n - 1]);
    }
}
int main(){
       int n,sum;
       cin >> n >> sum;
       vector<int>a(n);
       for(int i=0;i<n;i++)cin >> a[i];
       cout << subsetSum(a,n,sum) << "\n";
}
