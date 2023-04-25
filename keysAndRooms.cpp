#include <bits/stdc++.h>
using namespace std;




class Solution {
public:
    
     int canVisitAllRooms(vector<vector<int>>&rooms){
          //Find the size of the rooms
         int n = rooms.size();

           // Declare and initialize the visited array
         vector<bool>visited(n,false);
       

        //Declare a stack
         stack<int>st;


        // Push 0 into the stack
         st.push(0);


        //mark the 0 node as true
         visited[0] = true;

           //While the stack is not empty 
         while(!st.empty()){
              //pop the top element from the stack
              int node = st.top(); 
              st.pop();

              //Go to the neighbouring nodes 
              // and mark them as visited
              for(auto it: rooms[node]){
                    //if the element it is not visited
                   if(!visited[it]){
                       //mark it as true
                       visited[it] = true;

                       //push it into the stack
                       st.push(it);
                   }
              }
         }


         
         // If all nodes are visited then return false
         for(bool v: visited)if(!v)return false;


         //otherwise return true
          return true;

     }
};
