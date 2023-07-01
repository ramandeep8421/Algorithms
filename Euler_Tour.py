# Python program to print Euler tour of a tree.
from collections import defaultdict

# Adjacency list representation of tree
adj = defaultdict(list)

# Visited dictionary to keep track of visited nodes on our tour
vis = defaultdict(bool)

# defaultdict to store Euler Tour
MAX = 1001
Euler = [0]*(2*MAX)

# Function to add edges to tree
def add_edge(u, v):
adj[u].append(v)
adj[v].append(u)

# Function to store Euler Tour of Tree
def eulerTree(u, index):
vis[u] = True
Euler[index] = u
index += 1
for nbr in adj[u]:
	if not vis[nbr]:
	index = eulerTree(nbr, index)
	Euler[index] = u
	index += 1
return index
	
# Function to print Euler Tour of Tree
def printEulerTour(root, N):
index = 0
eulerTree(root, index)
for i in range(2*N-1):
	print(Euler[i], end=" ")
	
# Driver Code
N = 4
add_edge(1, 2)
add_edge(2, 3)
add_edge(2, 4)

printEulerTour(1, N)
