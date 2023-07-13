class Solution
{
	public:
	//Function to find the shortest distance of all the vertices
    //from the source vertex S.
    vector <int> dijkstra(int V, vector<vector<int>> adj[], int S)
    {
        // Code here
        int INF = 1e9;
        vector<int>distance(V+1,INF);
        
        distance[S]=0;
        
        set<pair<int,int>>st;
        
        st.insert({0,S});
        
        while(!st.empty()){
              
               auto it = *st.begin();
               
               st.erase(it);
               if(distance[it.second] < it.first)continue;
               
               for(auto neighbor: adj[it.second]){
                     
                       int to = neighbor[0];
                       int wt = neighbor[1];
                       
                       if(distance[to] > wt + distance[it.second]){
                            
                            if(distance[to] != INF){
                                 st.erase({distance[to], to});
                            }
                            distance[to] = wt + distance[it.second];
                            st.insert({distance[to], to});
                       }
               }
               
        }
        
        return distance;
    }
};
