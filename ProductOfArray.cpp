class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
         int n = nums.size();
         vector<int>prefix(n,1);
         int res = 1;
         prefix[0]=nums[0];

         for(int i=1;i<n;i++){
               prefix[i] = prefix[i-1]*nums[i];
         }

         for(int i=n-1;i>=1;i--){
               prefix[i] = prefix[i-1]*res;
               res *= nums[i];
         }
         prefix[0] = res;
         return prefix;
    }
};
