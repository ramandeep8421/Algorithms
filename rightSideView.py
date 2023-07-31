class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        res = []
        self.helper(root, 0, res)
        return res

    def helper(self, node: TreeNode, level: int, ans: List[int]) -> None:
        if not node:
            return

        if level == len(ans):
            ans.append(node.val)

        self.helper(node.right, level + 1, ans)
        self.helper(node.left, level + 1, ans)
