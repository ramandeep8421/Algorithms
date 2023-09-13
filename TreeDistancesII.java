import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static int dfs(int par, int node, int depth, List<Integer>[] adj, int[] dp, int[] ans) {
        ans[1] += depth;

        for (int child : adj[node]) {
            if (child != par) {
                dfs(node, child, depth + 1, adj, dp, ans);
                dp[node] += dp[child];
            }
        }
        return dp[node];
    }

    static void dfs2(int par, int node, int n, List<Integer>[] adj, int[] dp, int[] ans) {
        for (int child : adj[node]) {
            if (child != par) {
                ans[child] = ans[node] + (n - 2 * (dp[child]));
                dfs2(node, child, n, adj, dp, ans);
            }
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int n = sc.nextInt();

        List<Integer>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        int[] dp = new int[n + 1];
        int[] ans = new int[n + 1];

        dfs(0, 1, 0, adj, dp, ans);
        dfs2(0, 1, n, adj, dp, ans);

        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
