from typing import List
from collections import defaultdict


class Solution:
    def __init__(self):
        self.wordCount = defaultdict(int)
        self.n = 0
        self.wordLength = 0
        self.substringSize = 0
        self.k = 0
        
    def slidingWindow(self, left: int, s: str, answer: List[int]) -> None:
        wordsFound = defaultdict(int)
        wordsUsed = 0
        excessWord = False
        
        # Do the same iteration pattern as the previous approach - iterate
        # word_length at a time, and at each iteration we focus on one word
        for right in range(left, self.n - self.wordLength + 1, self.wordLength):
            sub = s[right:right+self.wordLength]
            if sub not in self.wordCount:
                # Mismatched word - reset the window
                wordsFound.clear()
                wordsUsed = 0
                excessWord = False
                left = right + self.wordLength
            else:
                # If we reached max window size or have an excess word
                while right - left == self.substringSize or excessWord:
                    leftmostWord = s[left:left+self.wordLength]
                    left += self.wordLength
                    wordsFound[leftmostWord] -= 1

                    if wordsFound[leftmostWord] >= self.wordCount[leftmostWord]:
                        # This word was an excess word
                        excessWord = False
                    else:
                        # Otherwise we actually needed it
                        wordsUsed -= 1
                
                # Keep track of how many times this word occurs in the window
                wordsFound[sub] += 1
                if wordsFound[sub] <= self.wordCount[sub]:
                    wordsUsed += 1
                else:
                    # Found too many instances already
                    excessWord = True
                
                if wordsUsed == self.k and not excessWord:
                    # Found a valid substring
                    answer.append(left)
        
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        self.n = len(s)
        self.k = len(words)
        self.wordLength = len(words[0])
        self.substringSize = self.wordLength * self.k
        
        for word in words:
            self.wordCount[word] += 1
        
        answer = []
        for i in range(self.wordLength):
            self.slidingWindow(i, s, answer)
        
        return answer
