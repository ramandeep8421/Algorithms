#include<bits/stdc++.h>
using namespace std;
#define ll long long 

 class Solution{
    
     public:

         int secondMinimumTime(int n, vector<int>&edges, int time, int change){
              vector<vector<int>>adj(n+1);

              for(auto edge: edges){
                  adj[edge[0]].push_back(edge[1]);
                  adj[edge[1]].push_back(edge[0]);
              }

              priority_queue<pair<int,int>, vector<pair<int,int>>, greater<int,int>>>minHeap;

              vector<int>dist1(n+1, INT_MAX), dist2(n+1,INT_MAX), freq(n+1,0);

              minHeap.push({0,1});

              while(!minHeap.empty()){
                   [timeTaken, node] = minHeap.top();
                   minHeap.pop();

                   freq[node]++;

                   if(freq[node] == 2 and node == n){
                       return timeTaken;
                   }

                   if((timeTaken/change)%2){
                       timeTaken = change * (timeTaken/change + 1) + time;
                   }else{
                      timeTaken = timeTaken + time;
                   }

                   for(auto neighbor: adj[node]){

                        if(dist1[neighbor] > timeTaken){
                            dist2[neighbor] = dist1[neighbor];
                            dist1[neighbor] = timeTaken;
                            minHeap.push({timeTaken, neighbor});
                        }else if(dist2[neighbor] > timeTaken and dist1[neighbor] != timeTaken){
                            dist2[neighbor] = timeTaken;
                            minHeap.push({timeTaken,neighbor});
                        }
                   }

              }

              return 0;
         }
 };     
