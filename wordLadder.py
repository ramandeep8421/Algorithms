from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        # queue to hold the nodes
        queue = deque([(beginWord, 1)])
         
        # declare the hashmaps
        mp = {word: 1 for word in wordList}
        visited = {}

        while queue:
            # Size of the queue
            n = len(queue)

            # Iterate n times
            for i in range(n):
                currWord, currCount = queue.popleft()

                if currWord == endWord:
                    return currCount

                visited[currWord] = True

                for j in range(len(currWord)):
                    org_char = currWord[j]

                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        newWord = currWord[:j] + c + currWord[j+1:]

                        if newWord not in visited and newWord in mp:
                            queue.append((newWord, currCount+1))
                            visited[newWord] = True

                    currWord = currWord[:j] + org_char + currWord[j+1:]

        return 0
