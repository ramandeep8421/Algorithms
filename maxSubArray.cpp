class Solution {
public:
    int maxSubArray(vector<int>& nums) {
         int maxi = 0;
         int max_sum_so_far = INT_MIN;

         for(auto it: nums){
               maxi += it;
               if(maxi > max_sum_so_far)max_sum_so_far = maxi;
               if(maxi < 0)maxi = 0;
         }


         return max_sum_so_far;
    }
};
