class Solution {
public:
   
   int lower_bound(vector<int>&nums, int target){
         int lo = 0, hi = nums.size()-1;
         int ans=nums.size();

         while(lo <= hi){
              int mid = lo + (hi - lo)/2;

              if(nums[mid] >= target){
                   ans = mid;
                   hi = mid-1;
              }else{
                    lo = mid+1;
              }
         }

         return ans;
   }
 
    vector<int> searchRange(vector<int>& nums, int target) {
         int first = lower_bound(nums, target);
         int last = lower_bound(nums, target+1)-1;

         if(first < nums.size() and nums[first] == target)return {first, last};

         return {-1,-1};
    }
};
