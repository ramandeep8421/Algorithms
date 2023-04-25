 

class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:

        # Find the size of the rooms
        n = len(rooms)

        # Declare and initialize the visited array
        visited = [False] * n

        # Declare a stack
        st = []

        # Push 0 into the stack
        st.append(0)

        # mark the 0 node as true
        visited[0] = True

        # While the stack is not empty
        while len(st) > 0:

            # pop the top element from the stack
            node = st.pop()

            # Go to the neighbouring nodes
            # and mark them as visited
            for it in rooms[node]:
                # if the element it is not visited
                if not visited[it]:
                    # mark it as true
                    visited[it] = True

                    # push it into the stack
                    st.append(it)

        # If all nodes are visited then return false
        for v in visited:
            if not v:
                return False

        # otherwise return false
        return True
