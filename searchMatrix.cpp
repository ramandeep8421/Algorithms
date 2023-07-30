class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n = matrix.size();
        int m = matrix[0].size();

        int lo = 0, hi = n*m - 1;

        while(lo < hi){
              int mid = lo  + (hi - lo)/2;

              if(matrix[mid/m][mid%m] < target)
                   lo = mid+1;
              else
                  hi = mid;
        }
        // lower bound will be stored in lo 

        return matrix[lo/m][lo%m] == target;
    }
};
