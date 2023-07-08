import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] adj;
    static boolean[] vis;
    static List<Integer> v;
    static int[] v1;

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            adj[b].add(a);
        }
        vis = new boolean[n + 1];
        v = new ArrayList<>();
        v1 = new int[n + 1];
        boolean cycleExists = false;
        for (int i = 1; i <= n; i++) {
            if (v1[i] == 0 && cycle(i)) {
                out.println("IMPOSSIBLE");
                out.close();
                return;
            }
            if (!vis[i]) {
                dfs(i);
            }
        }
        for (int i : v) {
            out.print(i + " ");
        }
        out.close();
    }

    static void dfs(int s) {
        if (vis[s]) {
            return;
        }
        vis[s] = true;
        for (int i : adj[s]) {
            dfs(i);
        }
        v.add(s);
    }

    static boolean cycle(int s) {
        v1[s] = 1;
        for (int i : adj[s]) {
            if (v1[i] == 0) {
                if (cycle(i)) {
                    return true;
                }
            } else if (v1[i] == 1) {
                return true;
            }
        }
        v1[s] = 2;
        return false;
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
