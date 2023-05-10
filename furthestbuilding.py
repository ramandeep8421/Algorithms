from typing import List

class Solution:
    def check(self, heights: List[int], bricks: int, ladders: int, mid: int) -> bool:
        diff = []
        for i in range(1, mid+1):
            if heights[i] > heights[i-1]:
                diff.append(heights[i]-heights[i-1])
        diff = sorted(diff, key=lambda x: -x)
        l = len(diff)
        for i in range(ladders, l):
            if diff[i] > bricks:
                return False
            bricks -= diff[i]
        return True

    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        n = len(heights)
        lo, hi = 0, n-1
        while lo < hi:
            mid = (lo+hi+1) // 2
            if self.check(heights, bricks, ladders, mid):
                lo = mid
            else:
                hi = mid-1
        return lo
