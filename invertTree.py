class Solution:
    def invert(self, node):
        if node is None:
            return

        temp = node.left
        node.left = node.right
        node.right = temp

        self.invert(node.left)
        self.invert(node.right)

    def invertTree(self, root):
        self.invert(root)
        return root
