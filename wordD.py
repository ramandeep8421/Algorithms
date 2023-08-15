class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

class WordDictionary:
    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        p = self.root
        for c in word:
            if p.children[ord(c) - ord('a')] is None:
                p.children[ord(c) - ord('a')] = TrieNode()
            p = p.children[ord(c) - ord('a')]
        p.isEnd = True

    def search(self, word: str) -> bool:
        return self.searchHelper(word, self.root)

    def searchHelper(self, word: str, node: TrieNode) -> bool:
        for i in range(len(word)):
            c = word[i]
            if c == '.':
                for child in node.children:
                    if child and self.searchHelper(word[i+1:], child):
                        return True
                return False
            
            if node.children[ord(c) - ord('a')] is None:
                return False
            node = node.children[ord(c) - ord('a')]
        
        return node.isEnd
