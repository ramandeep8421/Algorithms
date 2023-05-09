import heapq

class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        n = len(heights)
        i, diff = 0, 0
        pq = []

        for i in range(n - 1):
            diff = heights[i + 1] - heights[i]
            if diff <= 0:
                continue

            bricks -= diff

            heapq.heappush(pq, -diff)

            if bricks < 0:
                bricks += -heapq.heappop(pq)
                ladders -= 1

            if ladders < 0:
                break

        return i
