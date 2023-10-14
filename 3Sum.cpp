class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
         
          vector<vector<int>>ans;

          int n = nums.size();

          sort(nums.begin(),nums.end()); // O(nlogn)

          for(int i=0;i<n-2;i++){  // O(n*n) + O(nlogn) = O(n*n)
                 int target = -nums[i];

                 if(i > 0 and nums[i] == nums[i-1])continue;

                 int j = i+1, k = n-1;
                 while(j < k){
                        
                         if(nums[j] + nums[k] == target){
                                ans.push_back({nums[i],nums[j],nums[k]});

                                while(j+1 < k and nums[j] == nums[j+1])j++;

                                while(k-1 > j and nums[k] == nums[k-1])k--;

                                j++;
                                k--;
                         }else if(nums[j] + nums[k] < target){
                               j++;
                         }else{
                               k--;
                         }
                 }


          }

          return ans;
    }
};
