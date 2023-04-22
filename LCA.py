# Definition for TreeNode
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def __init__(self):
        self.ans = None

    def recursionTree(self, currNode: TreeNode, p: TreeNode, q: TreeNode) -> bool:
        if not currNode:
            return False

        left = 1 if self.recursionTree(currNode.left, p, q) else 0
        right = 1 if self.recursionTree(currNode.right, p, q) else 0

        mid = 1 if currNode == p or currNode == q else 0

        if mid + left + right >= 2:
            self.ans = currNode

        return mid + left + right > 0

    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        self.recursionTree(root, p, q)
        return self.ans
