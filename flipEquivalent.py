class Solution:
    def flipEquiv(self, root1: TreeNode, root2: TreeNode) -> bool:
        if root1 == root2:
            return True
        if root1 is None or root2 is None or root1.val != root2.val:
            return False
        return (self.flipEquiv(root1.left, root2.left) and self.flipEquiv(root1.right, root2.right) or
                self.flipEquiv(root1.left, root2.right) and self.flipEquiv(root1.right, root2.left))
