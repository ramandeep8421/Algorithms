class Solution {
public:
    int lengthOfLongestSubstring(string s) {
         vector<int>freq(258,0);

         int left = 0, right = 0, ans = 0;
          
         int n = s.length();

         while(right < n){
         
              if(freq[s[right]]){
                     ans = max(ans, right-left);

                     while(freq[s[right]] > 0){
                           freq[s[left]]--;
                           left++;
                     }
              }else{
                    freq[s[right]]++;
                    right++;
              }
         }

         ans = max(ans, right-left);

         return ans;
        
    }
};
