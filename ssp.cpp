#include<bits/stdc++.h>
using namespace std;


class Solution {
     
     public:

  
         
        int shortestPath(vector<vector<int>>&grid, int k){

             //find the dimensions of the grid
              int n = grid.size();
              int m = grid[0].size();



              //DIrection vector
              vector<int>dir{0,1,0,-1,0};


              int steps = 0;
                

              //lives array to optimize the use of obstacle removal power
              vector<vector<int>>lives(n,vector<int>(m,-1));


              //Declare a queue to push the elements
              queue<vector<int>>qu;
   

              qu.push({0,0,k});

             while(!qu.empty()){
                   
                    int size = qu.size();

                    for(int i=0;i<size;i++){

                          int row = qu.front()[0];
                          int col = qu.front()[1];

                          int currLives = qu.front()[2];

                          qu.pop();

                          if(row == rows-1 and col == cols-1)return steps;

                          if(grid[row][col] == 1)return currLives--;
                          
                          for(int i=0;i<4;i++){
                              int newRow = row + dir[0];
                              int newCol = col + dir[1];

                              if(newRow >= 0 and newCol >= 0 and newRow < rows and newCol < cols and lives[newRow][newCol] < currLives){
                                      lives[newRow][newCol] = currLives;
                                      qu.push({newRow,newCol,currLives});
                              }
                          }
                    }

                    steps++;
              }
        
           return -1;


       }
         	 
};
