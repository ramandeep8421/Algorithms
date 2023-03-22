class TrieNode:
    def __init__(self):
        # Boolean variable to mark the end of a word
        self.isCompleteWord = False
        # Trienode each containing a pointer to that particular character
        self.children = [None]*26

class WordDictionary:
    def __init__(self):
        # This is the root node
        self.root = TrieNode()
        
    # Function to add a new word in the trie
    def addWord(self, word):
        # Node initialized to root
        node = self.root
        
        # Iterate over the word and add this word into the dictionary
        for ch in word:
            # locate the particular index for the given character in the node
            idx = ord(ch) - ord('a')
              
            if node.children[idx] is None:
                node.children[idx] = TrieNode()
                
            node = node.children[idx]
          
        # Mark the end of the word as true
        node.isCompleteWord = True
        
    # Function to search for the word
    def search(self, word, node=None):
        if node is None:
            node = self.root
        
        for i in range(len(word)):
            c = word[i]
            # If the current character is a dot then check by putting each character at this position and validating the word if it exists or not
            if c == '.':
                for ch in node.children:
                    if ch and self.search(word[i+1:], ch):
                        return True
                return False
            # Find the index for that particular character
            idx = ord(c) - ord('a')
            
            # If the pointer for this node is None then return False
            if node.children[idx] is None:
                return False
            
            # Otherwise move the node to the next node
            node = node.children[idx]
        
        # Check if the word is complete or not
        return node.isCompleteWord
