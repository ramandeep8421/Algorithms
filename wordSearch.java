import java.util.*;

class Solution {
    public boolean exist(List<List<Character>> b, String w) {
        int n = b.size();
        int m = b.get(0).size();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(b.get(i).get(j) == w.charAt(0)) {
                    char t = b.get(i).get(j);
                    b.get(i).set(j, '1');

                    if(solve(i, j, n, m, 1, w, b))
                        return true;

                    b.get(i).set(j, t);
                }
            }
        }

        return false;
    }

    public boolean solve(int i, int j, int n, int m, int in, String w, List<List<Character>> b) {
        if(in == w.length())
            return true;

        int[] dir = {0, 1, 0, -1, 0};

        for(int k = 0; k < 4; k++) {
            int nx = i + dir[k];
            int ny = j + dir[k+1];
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= m || b.get(nx).get(ny) == '1' || b.get(nx).get(ny) != w.charAt(in))
                continue;

            char t = b.get(nx).get(ny);
            b.get(nx).set(ny, '1');

            if(solve(nx, ny, n, m, in+1, w, b))
                return true;

            b.get(nx).set(ny, t);
        }

        return false;
    }
}
