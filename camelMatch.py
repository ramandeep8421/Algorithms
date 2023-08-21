class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False

class Solution:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        cur = self.root
        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode()
            cur = cur.children[c]
        cur.isEnd = True
    
    def search(self, word):
        cur = self.root
        for c in word:
            if c not in cur.children and c.isupper():
                return False
            
            if c in cur.children:
                cur = cur.children[c]
        return cur.isEnd
    
    def camelMatch(self, queries, pattern):
        res = []
        self.insert(pattern)
        
        for query in queries:
            res.append(self.search(query))
        
        return res

# Example usage
solution = Solution()
queries = ["FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"]
pattern = "FB"
result = solution.camelMatch(queries, pattern)
print(result)
