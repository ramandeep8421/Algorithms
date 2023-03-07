#include<bits/stdc++.h>
using namespace std;


int lengthOfLis(vector<int>&a){
    //declare an array to store the lis
    vector<int>sub;

    //size of the array a 
    int n = a.size();
    
    //Iterate over all indices of the given vector
    for(int i=0;i<n;i++){

         // Check if the subsequence is empty
         // or its last value is less than a[i]
         // then push the current value i.e. a[i]
         // into the sub array
         if(sub.empty() || sub[sub.size()-1] < a[i]){
             sub.push_back(a[i]);
         }else{
            // Find the index of the lower bound 
            // of the integer a[i] in the array a 
            int index = lower_bound(a.begin(), a.end(),a[i]) - a.begin();

            //Assign the a[i] at "index" location
            // i.e. updating the value at index
            a[index] = a[i];
         }
    }
  
    // here return the size of the subsequence
    return sub.size();
}

int main(){
        int n;
        cin >> n;
        vector<int>a(n);
        for(int i=0;i<n;i++)cin >> a[i];
        cout << lengthOfLis(a) << "\n";
}
