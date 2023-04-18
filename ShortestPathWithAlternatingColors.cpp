class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {

        //adjacency list to represent the given graph
         vector<vector<pair<int,int>>>adj(n);
        
         //red edges are represented by 0
         for(auto redEdge: redEdges){
              adj[redEdge[0]].push_back({redEdge[1],0});
         }

         //blue edges are represented by 1
         for(auto blueEdge: blueEdges){
               adj[blueEdge[0]].push_back({blueEdge[1],1});
         }
         
         //Declare an answer array
         vector<int>answer(n,-1);

         //Declare the visited array
         vector<vector<bool>>visited(n,vector<bool>(2));

         //declare an empty queue
         queue<vector<int>>q;


         //Insert the first tuple 
         //starting with node 0, with number of steps as 0 and undefined color -1
         q.push({0,0,-1});

         //Initialize the visited array
         visited[0][1] = visited[0][0] = true;

         //initialize the answer array
         answer[0]=0;

         while(!q.empty()){
             auto element = q.front();
             int node = element[0], steps = element[1], prevColor = element[2];
             q.pop();

             for(auto& [neighbor, color]: adj[node]){
                 if(!visited[neighbor][color] and color != prevColor){
                     visited[neighbor][color] =true;
                     q.push({neighbor, 1 + steps, color});
                     if(answer[neighbor] == -1)answer[neighbor] = 1 + steps;
                 }
             }
         }
        return answer;
    }
};
