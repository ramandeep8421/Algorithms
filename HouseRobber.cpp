class Solution {
public:

    int maxMoney(int i, vector<int>&nums, vector<int>&memo){
          if(i == 0)return memo[0] = nums[0];

          if(i == 1)return memo[1] = max(nums[1],nums[0]);

          if(memo[i] != -1)return memo[i];

          return memo[i] = max(nums[i] + maxMoney(i-2,nums,memo), maxMoney(i-1,nums,memo));


    }
    int rob(vector<int>& nums) {
          vector<int>memo(nums.size(),-1);
          return maxMoney(nums.size()-1, nums,memo);
    }
};
