class Solution {
public:
    int hammingDistance(int x, int y) {
         int z = x ^ y;
         int ans = 0;
         while(z){
                if(z&1){
                     ans++;
                }
                z >>= 1;
         }
         return ans;
    }
};
