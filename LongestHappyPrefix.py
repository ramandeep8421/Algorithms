class Solution:
    def piTable(self, pat):
        n = len(pat)
        pi = [0] * n

        i, length = 1, 0

        while i < n:
            if pat[i] == pat[length]:
                length += 1
                pi[i] = length
                i += 1
            else:
                if length != 0:
                    length = pi[length - 1]
                else:
                    pi[i] = 0
                    i += 1

        return pi

    def longestPrefix(self, s):
        pi = self.piTable(s)

        maxLen = pi[len(s) - 1]

        res = ""

        for char in s:
            if maxLen == 0:
                break
            res += char
            maxLen -= 1

        return res

# Example usage:
solution = Solution()
s = "ababab"
longest_prefix = solution.longestPrefix(s)
print("Longest Prefix:", longest_prefix)
