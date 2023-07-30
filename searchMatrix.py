class Solution:
    def searchMatrix(self, matrix, target):
        n = len(matrix)
        m = len(matrix[0])

        lo = 0
        hi = n * m - 1

        while lo < hi:
            mid = lo + (hi - lo) // 2

            if matrix[mid // m][mid % m] < target:
                lo = mid + 1
            else:
                hi = mid
        
        # lower bound will be stored in lo 
        return matrix[lo // m][lo % m] == target
