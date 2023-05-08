class Solution {
public:
        int minNumberOperations(vector<int>&target){
            int n = target.size();
             int prev = target[0];
             int ans = prev;

               for(int i = 1;i < n; i++){
                if(target[i] > prev){
                    ans += (target[i] - prev);
                }
                prev = target[i];
             }

                 return ans;
        }
};
