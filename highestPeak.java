import java.util.*;

class Solution {
    public int[][] highestPeak(int[][] water) {
        int n = water.length;
        int m = water[0].length;

        int[][] ans = new int[n][m];

        Queue<int[]> qu = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (water[i][j] == 1) {
                    ans[i][j] = 0;
                    qu.offer(new int[]{i, j});
                } else {
                    ans[i][j] = -1;
                }
            }
        }

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!qu.isEmpty()) {
            int[] p = qu.poll();

            int x = p[0], y = p[1];

            int v = ans[x][y];

            for (int i = 0; i < 4; i++) {
                int newX = x + directions[i][0];
                int newY = y + directions[i][1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && ans[newX][newY] == -1) {
                    ans[newX][newY] = v + 1;
                    qu.offer(new int[]{newX, newY});
                }
            }
        }

        return ans;
    }
}
