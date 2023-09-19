import sys

# Function to read integers from input
def read_int():
    return int(sys.stdin.readline().strip())

# Function to read a list of integers from input
def read_int_list():
    return list(map(int, sys.stdin.readline().split()))

# Function to calculate power with modulo
def power_mod(a, b, mod):
    result = 1
    while b > 0:
        if b % 2 == 1:
            result = (result * a) % mod
        a = (a * a) % mod
        b //= 2
    return result

# Function to calculate greatest common divisor (GCD)
def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)

# Function to find the minimum of two numbers
def min(a, b):
    return a if a < b else b

# Function to find the maximum of two numbers
def max(a, b):
    return a if a > b else b

# Function to calculate modulo with positive result
def mod(a, b):
    return ((a % b) + b) % b

# Function to check if a number is odd
def is_odd(n):
    return n & 1 != 0

# Depth First Search (DFS) function
def dfs(node, parent, level, tree, spt, levels):
    levels[node] = level
    spt[node][0] = parent
    for child in tree[node]:
        if child != parent:
            dfs(child, node, level + 1, tree, spt, levels)

# Initialize the Sparse Table
def initialize_spt(spt):
    for i in range(1, len(spt)):
        for j in range(1, len(spt[0])):
            if spt[i][j - 1] != -1:
                par = spt[i][j - 1]
                spt[i][j] = spt[par][j - 1]

# Find Lowest Common Ancestor (LCA) of two nodes
def find_lca(a, b, levels, spt):
    if levels[b] < levels[a]:
        a, b = b, a
    d = levels[b] - levels[a]
    while d:
        i = int(d.bit_length()) - 1
        b = spt[b][i]
        d -= 1 << i
    if a == b:
        return a
    for i in range(len(spt[0]) - 1, -1, -1):
        if spt[a][i] != -1 and spt[a][i] != spt[b][i]:
            a = spt[a][i]
            b = spt[b][i]
    return spt[a][0]

# Main function
def main():
    n, q = read_int_list()

    MAXN = 200111
    N = 20

    tree = [[] for _ in range(MAXN)]
    spt = [[-1] * N for _ in range(MAXN)]
    levels = [0] * MAXN

    for i in range(2, n + 1):
        e = read_int()
        tree[e].append(i)
        tree[i].append(e)

    dfs(1, -1, 0, tree, spt, levels)
    initialize_spt(spt)

    for _ in range(q):
        a, b = read_int_list()
        lca = find_lca(a, b, levels, spt)
        print(lca)

if __name__ == "__main__":
    main()
