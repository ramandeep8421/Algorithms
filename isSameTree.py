class Solution:
    def isSameTree(self, p, q):
        if p is None and q is None:
            return True

        if (p is None and q is not None) or (p is not None and q is None) or (q.val != p.val):
            return False

        if not self.isSameTree(p.left, q.left) or not self.isSameTree(p.right, q.right):
            return False

        return True
