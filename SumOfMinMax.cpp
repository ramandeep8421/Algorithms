#include<bits/stdc++.h>
using namespace std;


class Solution {
public:
   
     vector<int> findMinMax(vector<int>arr, int l, int r){
          //Declare the min and max variables 
          int min,max;

          //Base cases
          if(l == r){
              min = arr[l];
              max = arr[l];
          }

          else if(l+1 == r){
              if(arr[l] > arr[r]){
                  min = arr[r];
                  max = arr[l];
              }else{
                  min = arr[l];
                  max = arr[r];
              }
          }

          //Case where the size of the array is greater than 2
          // recursively divide the array
          else{
               int mid = l + (r-l)/2;
               //Call the function for the left and right subarrays
               vector<int> leftMinMax = findMinMax(arr,l,mid);
               vector<int> rightMinMax = findMinMax(arr,mid+1,r);
             
               //Compare these pairs to get the final pair for the range[l..r]
               if(leftMinMax[0] < rightMinMax[0]){
                   min = leftMinMax[0];

               }else{
                    min = rightMinMax[0];
               }
               if(leftMinMax[1] < rightMinMax[1]){
                   max = rightMinMax[1];
               }else{
                   max = leftMinMax[1];
               }

          }


          return {min,max};
     }
 
};

