class TreeNode:
    def __init__(self):
        self.data = 0
        self.left = None
        self.right = None


class Solution:
    def __init__(self):
        self.ans = 0

    # function to find the longest univalue path
    def longestUnivaluePath(self, root: TreeNode) -> int:
        self.ans = 0
        self.directionalLength(root)
        return self.ans

    # Function to find the longestUnivaluePath
    def directionalLength(self, root: TreeNode) -> int:
        # if we have empty tree, then return 0
        if not root:
            return 0

        # find the directionalLength for left subtree
        left = self.directionalLength(root.left)

        # find the directionalLength for right subtree
        right = self.directionalLength(root.right)

        # integers to store the length values
        dirRight, dirLeft = 0, 0

        # check for the longest univalue path in the left subtree
        if root.left and root.left.data == root.data:
            dirLeft += (left + 1)

        # check for the longest univalue path in the right subtree
        if root.right and root.right.data == root.data:
            dirRight += (right + 1)

        # find the max of the ans with the sum of univalue path
        self.ans = max(self.ans, dirLeft + dirRight)

        # return the max of left and right longest univalue path
        return max(dirLeft, dirRight)
