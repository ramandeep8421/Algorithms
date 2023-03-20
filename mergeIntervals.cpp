#include<bits/stdc++.h>
using namespace std;


class Solution {
public:
     vector<vector<int>>mergeIntervals(vector<vector<int>>intervals){
         //find the size of the intervals
           int n = intervals.size();

           

           //Sort the given array of intervals
           sort(intervals.begin(),intervals.end());


           //find the starting and ending indices of the interval
           int l = intervals[0][0];
           int r = intervals[0][1];

            //result array to store the final intervals
            vector<vector<int>>res;

            //Start iterating from the second interval 
           for(int i=1;i<n;i++){
            
               //check if the starting point of the
               // current interval is out of the bounds of 
               // first interval , then push the previous 
               // interval into the result array
               if(intervals[i][0] > r){
                    res.push_back({l,r});
                    //reinitialize the current interval
                    l = intervals[i][0];
                    r = intervals[i][1];
               }else{
                  // expand the current interval
                   r = max(intervals[i][1],r);
               }
           }


            //push the final interval into the array
           res.push_back({l,r});


           //return the result
           return res;
     }
};


