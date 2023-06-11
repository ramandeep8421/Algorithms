#include<bits/stdc++.h>
using namespace std;
#define int long long 
 
 class Solution{
    
     public:
 
        bool isValid(vector<int>&a, int k, int mid){
             int groups = 0, sum = 0;
             int n = a.size();
             for(int i=0;i<n;i++){
                 if(a[i] > mid)return false;
 
                 if(sum + a[i] > mid){
                     groups++;
                     sum=0;
                 }
                 sum += a[i];
             }
 
             if(sum > 0)groups++;
 
             return groups <= k;
        }
 
        int arrayDivision(vector<int>&a, int k){
            int lo = 0, hi = 0;
            int ans= 0;
 
            for(auto it: a)hi += it;
 
            while(lo <= hi){
 
                int mid = (hi + lo)/2;
 
                if(isValid(a, k, mid)){
                     hi = mid - 1;
                     ans = mid;
                }else{
                     lo = mid+1;
                }
            }
            return ans;
        }
 };     
 
 
int32_t main(){
    Solution obj;
 
    int n,k;
    cin >> n >> k;
 
    vector<int>a(n);
 
    for(int i=0;i<n;i++)cin >> a[i];
 
    cout << obj.arrayDivision(a,k) << "\n";
}
