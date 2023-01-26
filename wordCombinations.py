import sys
import operator

N,M = (5000005,30)
trie = [[0]*M]*N
isEnd = [False]*N
dp = [-1]*N
counter = 0
MOD = 100000007



def wordCombinations(index, s):
    if index == len(s):
        dp[index]=1
        return dp[index]

    node = 0
    ans = 0

    for i in range(index,len(s)):
        character = ord(s[i])-97
        if not trie[node][character]:
            dp[index]=ans
            return dp[index]
        if isEnd[node]:
            if dp[i+1] != -1:
                ans = (ans + dp[i+1])%MOD
            else:
                ans = (ans + wordCombinations(index+1,s))%MOD
                
    dp[index]=ans;

    return dp[index]


def insert(str):
    curr = 0
    global counter
    #print(str)
    for i in str:
      character = ord(i)-97
      if character < 0:
        break
      #print(character)
      if not trie[curr][character]:
        counter = operator.add(counter,1)
        trie[curr][character] = counter
      curr = trie[curr][character]

    isEnd[curr]=True

k=0

s = input("\n")
k = int(input())

i=0


while i < k:
   str = input()
   insert(str)
   i += 1
  

print(wordCombinations(0,s))


