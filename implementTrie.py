class Trie:
    def __init__(self):
        self.trie = [[0] * 26 for _ in range(200002)]
        self.isEnd = [False] * 200002
        self.root = 0
        self.counter = 0

    def insert(self, word):
        node = self.root
        for c in word:
            if self.trie[node][ord(c) - ord('a')] == 0:
                self.counter += 1
                self.trie[node][ord(c) - ord('a')] = self.counter
            node = self.trie[node][ord(c) - ord('a')]
        self.isEnd[node] = True

    def search(self, word):
        node = self.root
        for c in word:
            if self.trie[node][ord(c) - ord('a')] == 0:
                return False
            node = self.trie[node][ord(c) - ord('a')]
        return self.isEnd[node]

    def startsWith(self, prefix):
        node = self.root
        for c in prefix:
            if self.trie[node][ord(c) - ord('a')] == 0:
                return False
            node = self.trie[node][ord(c) - ord('a')]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
