class Trie:

    class TrieNode:
        def __init__(self):
            self.children = [None] * 26
            self.isEnd = False

    def __init__(self):
        self.root = self.TrieNode()

    def insert(self, word):
        p = self.root
        for c in word:
            index = ord(c) - ord('a')
            if p.children[index] is None:
                p.children[index] = self.TrieNode()
            p = p.children[index]
        p.isEnd = True

    def search(self, word):
        p = self.root
        for c in word:
            index = ord(c) - ord('a')
            if p.children[index] is None:
                return False
            p = p.children[index]
        return p.isEnd

    def startsWith(self, prefix):
        p = self.root
        for c in prefix:
            index = ord(c) - ord('a')
            if p.children[index] is None:
                return False
            p = p.children[index]
        return True
