class Solution {
public:
    int minRefuelStops(int target, int tank, vector<vector<int>>& stations) {
         int ans = 0, prev = 0;

         priority_queue<int>pq;

         for(auto station: stations){
               int location = station[0];
               int fuel = station[1];

               int d = location - prev;

               tank -= d;

               while(!pq.empty() and tank < 0){
                     tank += pq.top();
                     pq.pop();
                     ans++;
               }

               if(tank < 0)return -1;
               prev = location;
               pq.push(fuel);
         }

         tank -= (target - prev);

         while(!pq.empty() and tank < 0){
               tank += pq.top();
               pq.pop();
               ans++;
         }

         if(tank < 0)return -1;

         return ans;
    }
};
