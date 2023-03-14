from typing import List

class Solution:
    def pascalTriangle(self, N: int) -> List[List[int]]:
        # This stores our pascal's triangle
        res = []

        # Iterating over each row
        for i in range(N):
            # Resizing the array
            res.append([])
            res[i].append(1)

            # Assign 1 to the first and last location of this array
            for j in range(1, i):
                # Find the integer present in i-1th row and j-1th column
                # and add it with the integer present in i-1th row and jth column
                val = res[i-1][j-1] + res[i-1][j]
                res[i].append(val)

            if i > 0:
                res[i].append(1)

        return res
