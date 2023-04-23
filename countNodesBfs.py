from collections import deque

# Definition for TreeNode
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def countNodes(self, root: TreeNode) -> int:
        # Empty tree
        if not root:
            return 0

        # Queue
        qu = deque([root])

        ans = 0

        while qu:
            sz = len(qu)

            for i in range(sz):
                if qu[0].left:
                    qu.append(qu[0].left)
                if qu[0].right:
                    qu.append(qu[0].right)

                qu.popleft()
                ans += 1

        return ans
