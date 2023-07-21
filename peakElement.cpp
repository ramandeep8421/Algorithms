class Solution {
public:
    int findPeakElement(vector<int>& nums) {
         int n = nums.size();
         int l = 0, r = n-1;

         if(n == 1)return 0;

         if(nums[l] > nums[l+1])return 0;

         if(nums[r] > nums[r-1])return n-1;


         l++, r--;

         while(l <= r){
                
                 int mid = l + (r-l)/2;

                 if(nums[mid] > nums[mid+1] and nums[mid] > nums[mid-1]) return mid;

                 else if(nums[mid] < nums[mid+1])l = mid+1;

                 else r = mid-1;
         }

         return -1;
    }
};
