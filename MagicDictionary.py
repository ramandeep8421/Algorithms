class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

class MagicDictionary:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for c in word:
            index = ord(c) - ord('a')
            if node.children[index] is None:
                node.children[index] = TrieNode()
            node = node.children[index]
        node.isEnd = True

    def buildDict(self, dictionary):
        for word in dictionary:
            self.insert(word)

    def searchHelper(self, word, node, index, isReplaced):
        if index >= len(word):
            return node.isEnd and isReplaced
        curr = node
        curIndex = ord(word[index]) - ord('a')
        res = False
        for i in range(26):
            if curr.children[i]:
                if curIndex == i:
                    res = self.searchHelper(word, curr.children[i], index + 1, isReplaced)
                elif not isReplaced:
                    res = self.searchHelper(word, curr.children[i], index + 1, True)
            if res:
                return True
        return res

    def search(self, searchWord):
        return self.searchHelper(searchWord, self.root, 0, False)
