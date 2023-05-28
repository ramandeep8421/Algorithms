class Solution {
public:

       int maxProfit(vector<int>&prices){

           int n = prices.size();

           int mini = prices[0];
           int maxi = prices[1];
          
           int ans = 0;

           for(int i=0;i<n;i++){
               if(price[i] < mini){
                  mini = price[i];
                  maxi = price[i];

               }

               maxi = max(maxi, price[i]);
               ans = max(ans, maxi-mini);
           }

           return ans;
       }

};
