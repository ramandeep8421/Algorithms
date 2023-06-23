import java.util.*;

class Solution {
    public long minimalDays(int sx, int sy, int ex, int ey, String s) {
        int n = s.length();

        String direction = "UDLR";

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int[][] d = new int[100009][2];

        for (int i = 0; i < n; i++) {
            int id = -1;

            for (int j = 0; j < 4; j++) {
                if (direction.charAt(j) == s.charAt(i)) {
                    id = j;
                }
            }

            assert (id != -1);

            d[i + 1][0] = d[i][0] + dx[id];
            d[i + 1][1] = d[i][1] + dy[id];
        }

        long l = 0, r = (long) 1e18;

        while (r - l > 1) {
            long mid = (l + r) / 2;

            long cycles = mid / n;
            long rem = mid % n;

            long x = sx + d[(int) rem][0] + cycles * d[n][0];
            long y = sy + d[(int) rem][1] + cycles * d[n][1];

            long dist = Math.abs(x - ex) + Math.abs(y - ey);

            if (dist <= mid) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (r >= 1e17) {
            r = -1;
        }

        return r;
    }
}
