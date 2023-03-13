#include<bits/stdc++.h>
using namespace std;


class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {

         //sizes of the arrays 
        int n = nums1.size();
        int m = nums2.size();

        //sort the arrays
        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(),nums2.end());


        vector<int>res;

        //declare two pointers 
        int i=0,j=0;
        while(i < n and j < m){
           // if the elements at i and j matches 
            if(nums1[i] == nums2[j]){
                if(res.size() == 0){
                     res.push_back(nums1[i]);
                     i++;
                     j++;
                }else{
                     if(res[res.size()-1] == nums1[i]){
                         i++;
                         j++;
                     }else{
                          res.push_back(nums1[i]);
                          i++;
                          j++;
                     }
                }
            }else{ // IF they don't match
                  if(nums1[i] < nums2[j]){
                       i++;
                  }else{
                       j++;
                  }
            }
        }
        return res;
    }
};

int main(){
        int n,m;
        cin >> n >> m;
        vector<int>nums1(n),nums2(m);
        for(int i=0;i<n;i++)cin >> nums1[i];
        for(int i=0;i<m;i++)cin >> nums2[i];
        Solution obj;
        vector<int>res = obj.intersection(nums1,nums2);
        for(auto it: res)
            cout << it << " ";
        

}
