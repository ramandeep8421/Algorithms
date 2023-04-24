# Definition for TreeNode
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def rob(self, root: TreeNode) -> int:
        p = self.solve(root)
        return max(p[0], p[1])

    def solve(self, root: TreeNode) -> tuple:
        if root is None:
            return (0, 0)
        p1 = self.solve(root.left)
        p2 = self.solve(root.right)
        p = (0, 0)
        p = (root.val + p1[1] + p2[1], 
             max(p1[0], p1[1]) + max(p2[0], p2[1]))
        return p
