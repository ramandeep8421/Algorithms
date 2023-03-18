class Solution:
   
    def findLongestConseqSubseq(self, arr: List[int]) -> int:
          
        # Set to store the elements of arr
        st = set(arr)

        # Variable to find the longest consecutive subsequence
        ans = 1

        # size of the input array
        n = len(arr)

        for i in range(n):
            # Check if the previous element arr[i]-1 
            # is present in the sequence, if present 
            # then this is not the starting point of the 
            # subsequence
            if arr[i]-1 in st:
                continue
            else:
                # Otherwise this is the starting point of the 
                # subsequence
                j = arr[i]
                while j in st:
                    j += 1

                ans = max(ans, j-arr[i])
                
        return ans
