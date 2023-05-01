from typing import List

class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        st = []

        count = 1
        n = len(s)

        for i in range(n):
            if not st:
                st.append((s[i], count))
                continue
            elif st[-1][0] == s[i]:
                st[-1] = (s[i], st[-1][1] + 1)

                if st[-1][1] == k:
                    st.pop()
            else:
                count = 1
                st.append((s[i], count))

        ans = ""

        while st:
            while st[-1][1] > 0:
                ans += st[-1][0]
                st[-1] = (st[-1][0], st[-1][1] - 1)
            st.pop()

        return ans[::-1]
