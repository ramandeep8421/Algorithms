#include<bits/stdc++.h>
using namespace std;
#define ll long long 

 class Solution{
    
     public:

         struct Tuple{
            int node, mask, cost;
         };

         int shortestPathLength(vector<vector<int>>&graph){
             int n = graph.size();

             queue<Tuple>qu;

             set<pair<int,int>>st;

             for(int i=0;i<n;i++){
                  struct Tuple head = {i, (1 << i), 0};
                  
                  st.push({i,(1 << i)});

                  qu.push(head);

             }

             while(!qu.empty()){

                   struct Tuple tup = qu.front();

                   qu.pop();

                   if(tup.mask == ((1 << n) - 1)){
                       return tup.cost;
                   }

                   for(auto child: graph[tup.node]){
                        int bitMask = tup.mask | (1 << child);

                        if(st.find({child, bitMask}) == st.end()){
                             st.insert({child, bitMask});

                             qu.push({child, bitMask, tup.cost + 1});
                        }
                   }
             }


             return -1;
         }
 };     


 
