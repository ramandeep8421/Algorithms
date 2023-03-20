#include<bits/stdc++.h>
using namespace std;


class Solution {
public:
     
         int maxArea(vector<int>height){
         //Find the size of the array
         int n = height.size();

         //Initialize two pointers i and j
         //i with first index and j with last index
         int i = 0, j = n-1;

         //answer variable to store the final 
         // answer
         int answer = 0;

         while(i < j){
             //Find the height of the 
             // container
             int h = min(height[i],height[j]);

             //Find the area of the container
             int area = h * (j-i);

             //Update the answer 
             answer = max(answer, area);

             //If height at index i 
             // is greater than the height at index j
             if(height[i] > height[j])j--;
             else i++;
         }

         return answer;
     }
          
      
};

