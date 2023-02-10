import sys
import operator



def findingBorders(pat):
    n = len(pat)
    
    pi = preprocessLPSTable(pat)

    result = []
    
    j = pi[len(pi)-1]

    while j > 0:
        result.append(j)
        j = pi[j-1]
   
    result.sort()
    for i in result:
        print(i," ")



def preprocessLPSTable(pattern):
  
     length = 0

     m = len(pattern)

     pi = [0]*m


     i = 1

     while i < m:
        if pattern[i] == pattern[length]:   
            length += 1
            pi[i] = length
            i += 1
        else:
            if length != 0:
                length = pi[length-1]
            else:
                pi[i]=0;
                i += 1

     return pi


s = input()
findingBorders(s)
