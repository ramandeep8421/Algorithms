class Solution {
public:
    int missingNumber(vector<int>& nums) {
         int missing = 0;
         int n = nums.size();
         for(int i=1;i<=n;i++)missing ^= i;

         for(auto it: nums)missing ^= it;

         return missing;
    }
};
