class Solution {
public:
    int maxProduct(vector<int>& nums) {
          int max_product_so_far = INT_MIN;
          int product = 1;

          for(auto it: nums){
               product *= it;
                max_product_so_far = max(max_product_so_far, product);
                if(product == 0)product = 1;
          }

          product = 1;
          for(int i=nums.size()-1;i>=0;i--){
                product *= nums[i];
                max_product_so_far = max(max_product_so_far,product);
                if(product == 0)product = 1;
          }

          return max_product_so_far;
    }
};
