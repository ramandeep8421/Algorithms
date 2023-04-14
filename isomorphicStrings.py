class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        mappingDictStoT = [-1] * 256
        mappingDictTtoS = [-1] * 256
        
        for i in range(len(s)):
            c1 = s[i]
            c2 = t[i]
            
            # Case 1: No mapping exists in either of the dictionaries
            if mappingDictStoT[ord(c1)] == -1 and mappingDictTtoS[ord(c2)] == -1:
                mappingDictStoT[ord(c1)] = ord(c2)
                mappingDictTtoS[ord(c2)] = ord(c1)
            
            # Case 2: Either mapping doesn't exist in one of the dictionaries or Mapping exists and
            # it doesn't match in either of the dictionaries or both 
            elif not (mappingDictStoT[ord(c1)] == ord(c2) and mappingDictTtoS[ord(c2)] == ord(c1)):
                return False
        
        return True
