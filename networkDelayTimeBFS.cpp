#include <bits/stdc++.h>
using namespace std;
 

class Solution {
public:
    // Adjacency list, defined it as per the maximum number of nodes
    // But can be defined with the input size as well
    vector<pair<int, int>> adj[101];
    
    void BFS(vector<int>& signalReceivedAt, int k) {
         queue<int>qu;
         qu.push(k);

         signalReceivedAt[k] = 0;

         while(!qu.empty()){

             int currNode = qu.front();
  
             qu.pop();

             for(auto edge: adj[currNode]){
                int time = edge.first;
                int neighbourNode = edge.second;

                int arrivalTime = signalReceivedAt[currNode] + time;

                if(signalReceivedAt[neighbourNode] > arrivalTime){
                    signalReceivedAt[neighbourNode] = arrivalTime;
                    qu.push(neighbourNode);
                }
             }
         }
    }
    
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
          // Build the adjacency list
        for (vector<int> time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            
            adj[source].push_back({travelTime, dest});
        

            }
 


        vector<int> signalReceivedAt(n + 1, INT_MAX);


        BFS(signalReceivedAt, k);


        int answer = INT_MIN;
        for (int node = 1; node <= n; node++) {
            answer = max(answer, signalReceivedAt[node]);
        }

        
      
        // INT_MAX signifies atleat one node is unreachable
        return answer == INT_MAX ? -1 : answer;
    }
        
};



