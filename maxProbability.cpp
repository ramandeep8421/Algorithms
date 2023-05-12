  class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
       double ans=0;
        priority_queue<pair<double, int>>q;
         q.push({1, start});
        vector<pair<int, double>>adj[n];

          for(int i=0; i<edges.size(); i++){
            adj[edges[i][0]].push_back({edges[i][1], succProb[i]});
            adj[edges[i][1]].push_back({edges[i][0], succProb[i]});
        }


        vector<double>probability(n, 0);

         probability[start]=1;


        while(!q.empty()){
            int pos=q.top().second;
            double cnt=q.top().first;
            q.pop();
            if(pos==end){ans=max(ans, cnt);}
            for(auto it: adj[pos]){
                if(cnt*it.second>probability[it.first]){
                    probability[it.first]=(double)cnt*it.second;
                    q.push({probability[it.first], it.first});
                }
            }
        }

        return ans;
    }
};
 
