class Solution {
public:
    int findMin(vector<int>& nums) {
        int lo = 0, hi = nums.size()-1;

        if(lo == hi)return nums[lo];

        if(nums[lo] < nums[hi])return nums[lo];

        while(lo <= hi){
              int mid = lo + (hi - lo)/2;

              if(mid-1 >= 0 and nums[mid-1] > nums[mid])
                  return nums[mid];

              else if(mid+1 <= hi and nums[mid+1] < nums[mid])
                  return nums[mid+1];
              
              else if(nums[mid] > nums[lo])
                   lo = mid+1;
                
              else
                   hi = mid-1;
        }

        return -1;
    }
};
