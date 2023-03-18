#include<bits/stdc++.h>
using namespace std;


class Solution {
public:
   
      int findLongestConseqSubseq(vector<int>&arr){
          
           //Set to store the elements of arr
           unordered_set<int>st;

             //Insert the elements into the hashset
           for(auto it: arr)st.insert(it);

             //Variable to find the longest consecutive subsequence
           int ans = 1;

          //size of the input array
           int n = arr.size();


           for(int i=0;i<n;i++){
                //Check if the previous element arr[i]-1 
                // is present in the sequence, if present 
                // then this is not the starting point of the 
                // subsequence
                if(st.find(arr[i]-1) != st.end())continue;

                else{
                    // Otherwise this is the starting point of the 
                    // subsequence
                    int j = arr[i];
                    while(st.find(j) != st.end())j++;

                    ans = max(ans,j-arr[i]);
                    
                }

           } 
           

      }
 
};

