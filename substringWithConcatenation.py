from collections import defaultdict

class SubstringWithConcactenation:
    def __init__(self):
        # Declare a global hashmap for <word, int> pair
        self.mp = defaultdict(int)

        # Declare the word length, substringSize and length of each word in given words dictionary
        self.wordLength = 0
        self.substringSize = 0
        self.k = 0

    # Function to check if the substring starting at i is a valid substring or not
    def check(self, i: int, s: str) -> bool:
        # First copy the given hashmap into the temporary map
        dict = defaultdict(int, self.mp)

        # It represents the number of words used in the given concatenation of words
        wordsUsed = 0

        # Start from index i and check for the substrings of length substringSize
        for j in range(i, i + self.substringSize, self.wordLength):
            # Find the first substring starting from i with length of wordLength
            sub = s[j:j + self.wordLength]

            if dict[sub] > 0:
                dict[sub] -= 1
                wordsUsed += 1
            else:
                break

        return wordsUsed == self.k

    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        # Size of the string
        n = len(s)

        # Size of the words array
        self.k = len(words)

        # Find the length of the word in the dictionary
        self.wordLength = len(words[0])

        # Find the substring size
        self.substringSize = self.wordLength * self.k

        # Build the hashmap for the given global map mp;
        for word in words:
            self.mp[word] += 1

        # Declare an answer array
        answer = []

        # Iterate over all the indices of the given string
        for i in range(n - self.substringSize + 1):
            if self.check(i, s):
                answer.append(i)

        return answer
