from typing import List
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Dist:
    def __init__(self, node: TreeNode, distance: int):
        self.node = node
        self.distance = distance

class Solution:
    def __init__(self):
        self.res = []
        self.mp = {}

    # Function to annotate parent
    def dfs(self, root: TreeNode, parent: TreeNode) -> None:
        if not root:
            return
        self.mp[root] = parent
        self.dfs(root.left, root)
        self.dfs(root.right, root)

    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        # In case of an empty tree
        if not root:
            return []

        # call the DFS function to annotate the binary tree
        self.dfs(root, None)

        # queue 
        qu = deque()
        qu.append(Dist(target, 0))

        vis = {}
        vis[target] = True

        while qu:
            d = qu.popleft()
            if d.distance == k:
                self.res.append(d.node.val)
                continue
            if d.node.left and not vis.get(d.node.left):
                qu.append(Dist(d.node.left, d.distance+1))
                vis[d.node.left] = True
            if d.node.right and not vis.get(d.node.right):
                qu.append(Dist(d.node.right, d.distance+1))
                vis[d.node.right] = True
            if self.mp.get(d.node) and not vis.get(self.mp[d.node]):
                qu.append(Dist(self.mp[d.node], d.distance+1))
                vis[self.mp[d.node]] = True

        return self.res
