import java.util.*;

class Solution {

    public boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x <= n-1 && y >= 0 && y <= m-1;
    }

    public int shortestPath(List<List<Integer>> grid, int k) {

        // find the dimensions of the grid
        int n = grid.size();
        int m = grid.get(0).size();

        // Direction vector
        List<Integer> dir = Arrays.asList(0, 1, 0, -1, 0);

        int steps = 0;

        // Lives array to optimize the use of obstacle removal power
        int[][] lives = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(lives[i], -1);
        }

        // Declare a queue to push the elements
        Queue<List<Integer>> qu = new LinkedList<>();
        qu.offer(Arrays.asList(0, 0, k));

        while (!qu.isEmpty()) {

            int size = qu.size();

            for (int i = 0; i < size; i++) {

                int row = qu.peek().get(0);
                int col = qu.peek().get(1);
                int currLives = qu.peek().get(2);

                qu.poll();

                if (row == n-1 && col == m-1) {
                    return steps;
                }

                if (grid.get(row).get(col) == 1) {
                    currLives--;
                }

                for (int j = 0; j < 4; j++) {
                    int newRow = row + dir.get(j);
                    int newCol = col + dir.get(j+1);

                    if (isValid(newRow, newCol, n, m) && lives[newRow][newCol] < currLives) {
                        lives[newRow][newCol] = currLives;
                        qu.offer(Arrays.asList(newRow, newCol, currLives));
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}

            



