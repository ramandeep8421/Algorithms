class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        freq = [0] * 258

        left = 0
        right = 0
        ans = 0

        n = len(s)

        while right < n:

            if freq[ord(s[right])]:
                ans = max(ans, right - left)

                while freq[ord(s[right])] > 0:
                    freq[ord(s[left])] -= 1
                    left += 1
            else:
                freq[ord(s[right])] += 1
                right += 1

        ans = max(ans, right - left)

        return ans

# Example usage
solution = Solution()
input_str = "abcabcbb"
result = solution.lengthOfLongestSubstring(input_str)
print("Length of longest substring without repeating characters:", result)
