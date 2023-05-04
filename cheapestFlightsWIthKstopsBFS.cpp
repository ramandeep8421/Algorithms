#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
 
      
        int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {

             //adjacency list to store the graph
              vector<vector<pair<int,int>>>adj(n);

         
            //generate the list from the given set of flights
              for(auto it: flights){
                  adj[it[0]].push_back({it[1],it[2]});
              }

            //declare a distance array
              vector<int>distance(n,numeric_limits<int>::max());

            

            //Declare a queue
            queue<pair<int,int>>qu;

            //Initialize it with the source vertex
            qu.push({src,0});

            //Initialize the stops to zero
            int stops = 0;

            //here the pair represents the  vertex and its 
            // distance from the source vertex
            while(stops <= k and !qu.empty()){
                  
                  //calculate the size of the queue
                 int size = qu.size();

                 while(size--){

                      //pop the front pair 
                      int node = qu.front().first;

                      //distance of the node from vertex
                      int dist = qu.front().second;

                      //pop the front node from the queue
                      qu.pop();

                      //move to the adjacent nodes
                      for(auto [neighbor, price]: adj[node]){

                          if(distance[neighbor] > dist + price){
                              distance[neighbor] = dist + price;
                              qu.push({neighbor, distance[neighbor]});
                          }
                      }
                 }
                 stops++;
            }

            return distance[dst] == INT_MAX ? -1 : distance[dst];

        }
};
