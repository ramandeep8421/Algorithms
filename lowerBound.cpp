#include<bits/stdc++.h>
using namespace std;
#define int long long 
#define fio ios_base::sync_with_stdio(false);

 class Solution{
    
     public:

        int upper_bound(int n, int a[], int target){
            int lo = 0 , hi = n-1;
            int ans = n;

            while(lo <= hi){

                 int mid = lo + (hi-lo)/2;

                 if(a[mid] > target){
                   ans = mid;
                   hi = mid-1;
                 }else{
                    lo = mid+1;
                 }
            }

            return ans;
        }
 };     


 
