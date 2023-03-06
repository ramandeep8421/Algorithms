#include<bits/stdc++.h>
using namespace std;


int lengthOfLis(vector<int>&a, int left, int right, int x){
     
      //size of the array a 
      int n = a.size();

      // perform the binary search on the range [left, right]
      while(left <= right){

          //Find the middle index
          int mid = left + (right-left)/2;

          //If the element we want to search 
          // is x and is less than equal to a[mid]
          // update the right pointer
          if(x <= a[mid]){
             right = mid;
          }
          // Otherwise, update the left pointer 
          else{
             left = mid + 1;
          }
      }
 
      // check if the left pointer does not exceed 
      // the length of the array a, and 
      // value at the index left is less than 
      // the required value x
      if(left < n and a[left] < x){
          left++;
      }

      return left;
}

int main(){
       int n,x;
       cin >> n >> x;
       vector<int>a(n);
       for(int i=0;i<n;i++)cin >> a[i];
       int left = 0, right = n-1;
       cout << lengthOfLis(a,left,right,x) << "\n";
}
