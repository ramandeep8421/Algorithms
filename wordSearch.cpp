#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
      
      bool exist(vector<vector<char>>&b , string w){
          int n = b.size();
          int m = b[0].size();

          for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                  if(b[i][j] == w[0]){

                      char t = b[i][j];
                      b[i][j] = '1';
                      if(solve(i,j,n,m,1,w,b))
                          return true;

                      b[i][j] = t;
                  }
             }
          }

          return false;
      }

      bool solve(int i, int j, int n, int m, int in, string w, vector<vector<char>>&b){
            if(in == w.size())
                return true;

            int dir[] = {0,1,0,-1,0};

            for(int k = 0; k < 4; k++){
               int nx = i + dir[k];
               int ny = j + dir[k+1];
              
               if(nx < 0 || ny < 0 || nx >= n || ny >= m || b[nx][ny] =='1' || b[nx][ny] != w[in])
                  continue;

               char t = b[nx][ny];

               b[nx][ny] = '1';

               if(solve(nx,ny,n,m,in+1,w,b))
                  return true;

                b[nx][ny] = t;
            }

            return false;
      }

};
