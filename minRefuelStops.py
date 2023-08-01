import heapq

class Solution:
    def minRefuelStops(self, target, tank, stations):
        ans, prev = 0, 0
        pq = []

        for station in stations:
            location, fuel = station[0], station[1]
            d = location - prev
            tank -= d

            while pq and tank < 0:
                tank += -heapq.heappop(pq)
                ans += 1

            if tank < 0:
                return -1

            prev = location
            heapq.heappush(pq, -fuel)

        tank -= (target - prev)

        while pq and tank < 0:
            tank += -heapq.heappop(pq)
            ans += 1

        if tank < 0:
            return -1

        return ans
