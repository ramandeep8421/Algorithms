import sys

sys.setrecursionlimit(10**6)

def init():
    pass

def isCycle(node, vis, recStack, st, adj):
    vis[node] = recStack[node] = 1
    st.append(node)

    for neighbor in adj[node]:
        if vis[neighbor] == 0:  # include it into the cycle
            if isCycle(neighbor, vis, recStack, st, adj):
                return True
        elif recStack[neighbor]:
            # back-edge
            st.append(neighbor)
            return True

    recStack[node] = 0
    st.pop()

    return False

def extract(st):
    node = st[-1]
    cycle = [node]
    st.pop()

    while st:
        cycle.append(st[-1])
        if st[-1] == node:
            break
        st.pop()

    return cycle

def roundTrip(n, adj):
    vis = [0] * (n + 1)
    recStack = [0] * (n + 1)
    st = []

    for i in range(1, n + 1):
        if not vis[i]:
            if isCycle(i, vis, recStack, st, adj):
                return extract(st)

    return []

def main():
    init()

    n, m = map(int, input().split())

    adj = [[] for _ in range(n + 1)]

    for _ in range(m):
        a, b = map(int, input().split())
        adj[a].append(b)

    cycle = roundTrip(n, adj)

    if len(cycle) == 0:
        print("IMPOSSIBLE")
        return

    cycle.reverse()
    print(len(cycle))

    for it in cycle:
        print(it, end=" ")

if __name__ == "__main__":
    main()
