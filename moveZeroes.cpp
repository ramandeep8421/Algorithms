#include <bits/stdc++.h>
using namespace std;

class Solution{

    public:
         //Function to move zeroes at the end
        // of the array
        vector<int>moveZeroes(vector<int>&nums){

             //lastNonZeroIndex
             int lastNonZeroIndex = 0;
             
             //Size of the nums array
             int n = nums.size();

             //Iterate over the array 
             for(int i=0;i<n;i++){
                  if(nums[i] != 0){
                     nums[lastNonZeroIndex] = nums[i];
                  }
             }

             //start from the lastNonZeroIndex to the end of the array
             // and place zero at the end of the array
             for(int i=lastNonZeroIndex; i < n; i++) 
                 nums[i] = 0;
             
        }
}
