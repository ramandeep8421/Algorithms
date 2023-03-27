class DungeonGame:
    def calculateMinimumHP(self, dungeon: List[List[int]]) -> int:
        # Calculate the dimensions of the dungeon
        n = len(dungeon)
        m = len(dungeon[0])

        # Declare a dp array for the corresponding dungeon
        dp = [[float('inf') for _ in range(m+1)] for _ in range(n+1)]

        # Initialize the bottom right cell
        dp[n-1][m] = dp[n][m-1] = 1

        # Iterating over the dp and fill it 
        for i in range(n-1, -1, -1):
            for j in range(m-1, -1, -1):
                value = min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]
                dp[i][j] = max(1, value)

        # The first position in the dp array contains 
        # the required answer !! 
        return dp[0][0]
