class Solution:
    def doesIntervalsOverlap(self, a: List[int], b: List[int]) -> bool:
        return min(a[1], b[1]) - max(a[0], b[0]) >= 0

    def mergeInterval(self, a: List[int], b: List[int]) -> List[int]:
        return [min(a[0], b[0]), max(a[1], b[1])]

    def insertInterval(self, intervals: List[List[int]], newInterval: List[int]) -> None:
        isIntervalInserted = False

        # insert the interval at the position
        for i in range(len(intervals)):
            if newInterval[0] < intervals[i][0]:
                intervals.insert(i, newInterval)
                isIntervalInserted = True
                break

        if not isIntervalInserted:
            intervals.append(newInterval)

    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        # insert the interval before merging process
        self.insertInterval(intervals, newInterval)

        # answer array
        answer = []

        # Iterate over all the intervals
        i = 0
        while i < len(intervals):
            # find the current interval
            currInterval = [intervals[i][0], intervals[i][1]]

            # merge until the list is exhausted
            # or no overlap is found
            while i < len(intervals) and self.doesIntervalsOverlap(currInterval, intervals[i]):
                currInterval = self.mergeInterval(currInterval, intervals[i])
                i += 1

            i -= 1
            # push the current interval into the answer array
            answer.append(currInterval)

            i += 1

        # return the answer from here
        return answer
