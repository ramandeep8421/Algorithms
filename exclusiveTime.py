from typing import List
from collections import deque

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        # answer array to store the final answer
        ans = [0] * n

        # declare a stack to store the pairs
        cur = deque()

        # prev time variable
        prevTime = 0

        for s in logs:
            id = int(s[:s.find(':')])
            time = int(s[s.rfind(':') + 1:])

            if 'end' in s:
                ans[id] += time - prevTime + 1
                cur.pop()
                prevTime = time + 1
            else:
                if cur:
                    ans[cur[-1][0]] += time - prevTime
                cur.append((id, time))
                prevTime = time

        return ans
