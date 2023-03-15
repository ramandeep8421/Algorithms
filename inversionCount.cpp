#include<bits/stdc++.h>
using namespace std;


class Solution {
public:
   
     void merge(vector<int>&arr, int left, int mid, int right, int &answer){
            
            //Sizes of the auxiliary arrays
            int n = mid-left+1;
            int m = right-mid;

            //Declare the auxiliary arrays
            vector<int>l(n),r(m);

            //Copy the elements into these arrays
            for(int i=0;i<=mid;i++)l[i+left] = arr[i];
            for(int i=mid+1;i<=right;i++)r[i+mid+1] = arr[i];


           //pointers to auxiliary arrays and parent array
              int i = 0, j = 0, k = left;

            //Copy the auxiliary arrays into parent array in 
            //sorted order
            while(i < n and j < m){
               if(l[i] <= r[j]){
                   arr[k] = l[i];
                   i++;
               }else{
                  arr[k] = r[j];
                  answer += (n-i);
                  j++;
               }
               k++;
            }
     }
     void mergeSort(vector<int>&arr, int left, int right, int &answer){
            //Base condition
            if(left >= right)return;

            //Find the middle point
            int mid = left + (right - left)/2;

            //Call the function for the left half and right half
            mergeSort(arr,left,mid,answer);
            mergeSort(arr,mid+1,right,answer);

            //Merge the two sequences
            merge(arr,left,mid,right,answer);

     }
     int countInversions(vector<int>&arr){

           //Initialize the answer variable
           int answer = 0;

           //Call the mergeSort Function to call
           // for the final answer 
           mergeSort(arr,0,arr.size()-1,answer);

           //Return the answer from here
           return answer;
     }
};

