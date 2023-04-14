#include <bits/stdc++.h>
using namespace std;

class Solution {
    
    public:

        
           bool doesIntervalsOverlap(vector<int>&a, vector<int>&b){
            return min(a[1],b[1]) - max(a[0],b[0]) >= 0;
      }


          vector<int>mergeInterval(vector<int>&a, vector<int>&b){
            return {min(a[0],b[0]),max(a[1],b[1])};
      }

   

           //Function to insert the interval into the intervals array
      void insertInterval(vector<vector<int>>&intervals, vector<int>&newInterval){
           bool isIntervalInserted = false;

           //insert the interval at the position 
           for(int i=0;i<intervals.size();i++){
               if(newInterval[0] < intervals[i][0]){
                    intervals.insert(intervals.begin() + i, newInterval);
                    isIntervalInserted = true;
                    break;
               }
           }
           
           if(!isIntervalInserted){
              intervals.push_back(newInterval);
           }

          
      }
       
       //Insert the interval at right position
      vector<vector<int>>insert(vector<vector<int>>&intervals, vector<int>&newInterval){
             
        //insert the interval before merging process
             insertInterval(intervals, newInterval);
       
       //answer array
             vector<vector<int>>answer;

              //Iterate over all the intervals
             for(int i=0;i<intervals.size();i++){

                 //find the current interval
                   vector<int>currInterval = {intervals[i][0], intervals[i][1]};
                  
                 //merge until the list is exhausted
                // or no overlap is found
                 while(i < intervals.size() and doesIntervalsOverlap(currInterval, intervals[i])){
                      currInterval =  mergeInterval(currInterval, intervals[i]);
                      i++;
                 }

                 i--;
                //push the current interval into the answer array
                answer.push_back(currInterval);

             }


            //return the answer from here
             return answer;
           
      }

};
