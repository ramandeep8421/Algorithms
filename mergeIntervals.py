class Solution:
    def mergeIntervals(self, intervals: List[List[int]]) -> List[List[int]]:
        #find the size of the intervals
        n = len(intervals)

        #Sort the given array of intervals
        intervals.sort()

        #find the starting and ending indices of the interval
        l = intervals[0][0]
        r = intervals[0][1]

        #result array to store the final intervals
        res = []

        #Start iterating from the second interval 
        for i in range(1,n):
            #check if the starting point of the
            # current interval is out of the bounds of 
            # first interval , then push the previous 
            # interval into the result array
            if intervals[i][0] > r:
                res.append([l,r])
                #reinitialize the current interval
                l = intervals[i][0]
                r = intervals[i][1]
            else:
                r = max(intervals[i][1],r)

        #push the final interval into the array
        res.append([l,r])

        #return the result
        return res
