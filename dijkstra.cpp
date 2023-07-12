#define INF 1000000000

class Solution
{
	public:
	//Function to find the shortest distance of all the vertices
    //from the source vertex S.
    vector <int> dijkstra(int N, vector<vector<int>> adj[], int src)
    {
        // Code here
        vector<int>distance(N,INF);
             
             distance[src]=0;
             
              priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>>pq;
              
              pq.push({0,src});
              
              while(!pq.empty()){
                  
                  int dist = pq.top().first;
                  int node = pq.top().second;
                  
                  pq.pop();
                  
                  if(dist > distance[node])continue;
                  
                  for(auto neighbor: adj[node]){
                        
                        int to = neighbor[0];
                        int wt = neighbor[1];
                        
                        if(distance[to] > dist + wt){
                            distance[to] = dist +wt;
                            pq.push({distance[to],to});
                        }
                  }
              }
              
              return distance;
    }
};
