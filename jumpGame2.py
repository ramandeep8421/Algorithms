class Solution:
    def jumpGameII(self, jumps):
        answer = 0
        left = 0
        right = 0

        n = len(jumps)

        while right < n:
            farthest = 0
            for i in range(left, right+1):
                farthest = max(farthest, i + jumps[i])
            left = right + 1
            right = farthest
            answer += 1

        return answer
