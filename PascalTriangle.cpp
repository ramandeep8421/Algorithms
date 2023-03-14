#include<bits/stdc++.h>
using namespace std;


class Solution {
public:
    vector<vector<int>>pascalTriangle(int N){
         
         //This stores our pascals triangle
         vector<vector<int>>res(N);
         
          //Iterating over each row
         for(int i=0;i<N;i++){
             //resizing the array
             res[i].resize(i+1);

             //Assign 1 to the first and last location of this array
             res[i][0] = res[i][i] = 1;

             //Iterate over each column and generate the number 
             for(int j=1;j<i;j++){
                 //Find the integer present in ith row
                 //and jth column
                 res[i][j] = res[i-1][j-1] + res[i-1][j];
             }
         }

         return res;
    }
};

