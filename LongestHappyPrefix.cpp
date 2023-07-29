class Solution {
public:
    vector<int>piTable(string pat){
          vector<int>pi;
          int n = pat.length();
          pi.resize(n);
          
          int i = 1, len = 0;

          while(i < n){
                if(pat[i] == pat[len]){
                     len++;
                     pi[i] = len;
                     i++;
                }else{
                      
                       if(len != 0){
                            len = pi[len-1];
                       }else{
                            
                            pi[i] = 0;
                            i++;
                       }
                }
          }

          return pi;
    }
    string longestPrefix(string s) {
         vector<int>pi = piTable(s);

         int maxLen = pi[s.length()-1];

         string res = "";

         for(auto it: s){
               if(maxLen == 0)break;
               res += it;
               maxLen--;
         }

         return res;
    }
};
