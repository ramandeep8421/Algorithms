class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
         unordered_map<int,int>mp;

       //map the elements to their indices
         for(int i=0;i<nums.size();i++){
               mp[nums[i]]=i;
         }

       for(int i=0;i<nums.size();i++){
              if(mp[target - nums[i]] and (mp[target - nums[i]] != i)){
                   return {i,mp[target-nums[i]]};
              }
       }

       return {};
    }
};