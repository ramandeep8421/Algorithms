import java.io.*;
import java.util.*;

class Main {
    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static void init() {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        Pair p = bfs(1, n, adj);
        Pair pp = bfs(p.first, n, adj);

        int[][] dp = new int[n + 1][2];
        dfs(0, p.first, 0, 0, adj, dp);
        dfs(0, pp.first, 0, 1, adj, dp);

        for (int i = 1; i <= n; i++) {
            System.out.print(Math.max(dp[i][0], dp[i][1]) + " ");
        }
    }

    static Pair bfs(int node, int n, ArrayList<Integer>[] adj) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, 0));

        boolean[] vis = new boolean[n + 1];
        vis[node] = true;

        Pair u = new Pair(0, 0);

        while (!q.isEmpty()) {
            u = q.poll();

            for (int child : adj[u.first]) {
                if (!vis[child]) {
                    q.add(new Pair(child, u.second + 1));
                    vis[child] = true;
                }
            }
        }

        return u;
    }

    static void dfs(int par, int node, int d, int c, ArrayList<Integer>[] adj, int[][] dp) {
        dp[node][c] = d;
        for (int child : adj[node]) {
            if (child != par) {
                dfs(node, child, d + 1, c, adj, dp);
            }
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
            st = new StringTokenizer("");
        }

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        init();
    }
}
