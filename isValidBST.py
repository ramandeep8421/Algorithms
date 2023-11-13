class Solution:
    def isValidBST(self, root):
        return self.check(root, float('-inf'), float('inf'))

    def check(self, node, lb, ub):
        if node is None:
            return True

        if not lb < node.val < ub:
            return False

        return self.check(node.left, lb, node.val) and self.check(node.right, node.val, ub)
