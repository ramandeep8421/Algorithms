import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;
    static int MAX = 200005;
    static boolean[] done = new boolean[MAX];

    static void dfs(int pre, int node, List<Integer>[] adj) {
        for (int child : adj[node]) {
            if (child != pre) {
                dfs(node, child, adj);
                if (!done[child] && !done[node]) {
                    done[child] = true;
                    done[node] = true;
                    ans++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner();
        int n = in.nextInt();

        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        Arrays.fill(done, false);
        dfs(0, 1, adj);

        System.out.println(ans);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
