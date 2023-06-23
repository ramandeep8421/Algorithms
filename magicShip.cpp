#include<bits/stdc++.h>
using namespace std;


class Solution
{
    public:

        long long minimalDays(sx, sy, ex,ey, string s){
             int n = s.length();

             string direction = "UDLR";

             int dx[] = {0,0,-1,1};
             int dy[] = {1,-1,0,0};
            
             pair<int,int>d[100009];

             for(int i=0;i<n;i++){
                  int id = -1;

                  for(int j=0;j<4;j++)
                       if(direction[j] == s[i])
                            id = j;

                  assert(id != -1);

                  d[i+1] = {d[i].first + dx[id] , d[i].second + dy[id]};

             }

             int l = 0, r = 1e18;

             while(r-l > 1){

                  long long mid = (l + r)/2;
                  
                  long long cycles = mid/n;
                  long long rem = mid%n;

                  long long x = sx + d[rem].first + cycles * d[n].first;

                  long long y = sy + d[rem].second + cycles * d[n].second;

                  long long dist = abs(x - ex) + abs(y - ey);

                  if(dist <= mid)
                       r = mid;

                  else
                       l = mid;

             }

             if(r >= 1e17)r = -1;


             return r;

        }

};
