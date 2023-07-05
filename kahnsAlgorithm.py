class Solution:
    def max(self, a, b):
        return a if a > b else b

    def dfs(self, mid, node, par, graph, tot, c):
        tot[node] = wt[node]

        arr = []

        for it in graph[node]:
            if it != par:
                arr.append(self.dfs(mid, it, node, graph, tot, c))

        arr.sort()

        for it in arr:
            if tot[node] + it > mid:
                c += 1
            else:
                tot[node] += it

        return tot[node]

    def minimumWeightSubtree(self, wt, graph, n, k):
        tot = [0] * (n + 1)

        mn = -1
        mx = 0

        for it in wt:
            mn = self.max(mn, it)
            mx += it

        ans = 0
        lo = mn
        hi = mx

        c = 0

        while lo <= hi:
            mid = lo + (hi - lo) // 2

            self.dfs(mid, 1, 0, graph, wt, tot, c)

            if c <= k - 1:
                ans = mid
                hi = mid - 1
            else:
                lo = mid + 1

        return ans
