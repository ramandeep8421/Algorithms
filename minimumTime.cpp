class Solution {
public:
    int minimumTime(int n, vector<vector<int>>& relations, vector<int>& time) {
        vector<int>adj[n];

        vector<int>inDegree(n,0);

        for(auto it: relations){
                int prev = it[0]-1;
                int next = it[1]-1;
                adj[prev].push_back(next);
                inDegree[next]++;
        }

        queue<int>q;

        vector<int>dist(n,0);

        for(int i=0;i<n;i++){
            if(inDegree[i] == 0){
                    q.push(i);
                    dist[i] = time[i];
            }
        }

        while(!q.empty()){
                int node = q.front();
                q.pop();

                for(auto neighbor: adj[node]){
                        inDegree[neighbor]--;
                        dist[neighbor] = max(dist[neighbor], dist[node] + time[neighbor]);
                        if(inDegree[neighbor] == 0){
                               q.push(neighbor);
                        }
                }
        }

        return *max_element(dist.begin(), dist.end());
       
    }
};
