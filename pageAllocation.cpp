#include<bits/stdc++.h>
using namespace std;
#define int long long 
#define fio ios_base::sync_with_stdio(false);

 class Solution{
    
     public:

       bool isValid(vector<int>&books, int curr_min, int m){
             int run_sum = 0;
              int students = 1;

             for(auto it: books){
                  if(it > curr_min)return false;

                  if(run_sum + it > curr_min){
                      students++;
                      run_sum = it;

                      if(students > m)return false;
                  }else{
                      run_sum += it;
                  }
             }

             return true;;
       }

        int minimumPagesAllocation(vector<int>&books, int m){
             int n = books.size();

             if(n > m)return -1;

             int lo = 0, hi = 0;

             for(auto it: books)hi += it;

              int ans = -1;

              //[lo , hi] => pages 

              while(lo<=hi){
                  int mid = lo + (hi-lo)/2;

                  if(isValid(books, mid, m)){
                      ans = mid;
                      hi = mid-1; // [lo , mid-1]
                  }else{
                      lo = mid+1; // [mid+1, hi]
                  }
              }

              return ans;
        }
 };     


 
