class Solution:
    class TrieNode:
        def __init__(self):
            self.zero = None
            self.one = None
    
    def insert(self, root, n):
        curr = root
        for i in range(31, -1, -1):
            bit = (n >> i) & 1
            if bit == 0:
                if curr.zero is None:
                    newNode = self.TrieNode()
                    curr.zero = newNode
                curr = curr.zero
            else:
                if curr.one is None:
                    newNode = self.TrieNode()
                    curr.one = newNode
                curr = curr.one
    
    def maximizeXor(self, root, n):
        curr = root
        ans = 0
        for i in range(31, -1, -1):
            bit = (n >> i) & 1
            if bit == 1:
                if curr.zero:
                    ans += (1 << i)
                    curr = curr.zero
                else:
                    curr = curr.one
            else:
                if curr.one:
                    ans += (1 << i)
                    curr = curr.one
                else:
                    curr = curr.zero
        return ans
    
    def findMaximumXOR(self, nums):
        n = len(nums)
        root = self.TrieNode()
        ans = 0
        for num in nums:
            self.insert(root, num)
        for i in range(1, n):
            ans = max(ans, self.maximizeXor(root, nums[i]))
        return ans
