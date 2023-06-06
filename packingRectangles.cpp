#include<bits/stdc++.h>
using namespace std;
#define ll long long 
 class Solution{
    
     public:
        ll max(ll a, ll b){
            return (a > b) ? a : b;
        }
        
        bool isValid(ll x, ll h, ll w, ll n){
            
            ll a = (x/h);
            ll b = (x/w);
            
            return (a * b) >= n;
            return (x/h) * (x/w) >= n;
        }

        ll minRectanglesInSquare(ll h, ll w, ll n){
              ll l = 0, r =  1;
              
                while (isValid(r, h, w, n) == false)
                     r *= 2;


              while(l < r){
                  ll mid = l + (r - l)/2;

                  if(isValid(mid,h,w,n)){
                      r = mid;
                  }else{
                      l = mid +1;
                  }
              }

              return l;
        }
        
 };     
 
 int main()
{
   Solution obj;
   ll h,w,n;
   cin >> w >> h >> n;
   cout << obj.minRectanglesInSquare(h,w,n) << "\n";
}
