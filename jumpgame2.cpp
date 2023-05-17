class Solution {
public:
     int jumpGameII(vector<int>&jumps){
        int answer = 0;
         int left = 0, right = 0;


         int n = jumps.size();
         while(right < n){
             int farthest = 0;
              for(int i=left;i<=right;i++){
                farthest = max(farthest, i + nums[i]);
             }

             left = right + 1;
             right = farthest;
             answer++;
         }

         

         return answer;

     }
};
