import java.io.*;
import java.util.*;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String inputFile) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(inputFile));
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static final int maxN = 200001;
    static final int logN = 20;

    static int N, M, a, b;
    static int[] sub = new int[maxN];
    static int[][] p = new int[maxN][logN];
    static int timer;
    static int[] in = new int[maxN];
    static int[] out = new int[maxN];
    static ArrayList<Integer>[] G = new ArrayList[maxN];

    static void dfs1(int u, int par) {
        in[u] = ++timer;
        p[u][0] = par;
        for (int i = 1; i < logN; i++)
            p[u][i] = p[p[u][i - 1]][i - 1];
        for (int v : G[u])
            if (v != par)
                dfs1(v, u);
        out[u] = ++timer;
    }

    static void dfs2(int u) {
        for (int v : G[u]) {
            if (v != p[u][0]) {
                dfs2(v);
                sub[u] += sub[v];
            }
        }
    }

    static boolean ancestor(int u, int v) {
        return in[u] <= in[v] && out[u] >= out[v];
    }

    static int lca(int u, int v) {
        if (ancestor(u, v)) return u;
        if (ancestor(v, u)) return v;
        for (int i = logN - 1; i >= 0; i--)
            if (!ancestor(p[u][i], v))
                u = p[u][i];
        return p[u][0];
    }

    static void solve() {
        int n, m;
        FastReader input = new FastReader();

        n = input.nextInt();
        m = input.nextInt();

        for (int i = 1; i <= n; i++)
            G[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            a = input.nextInt();
            b = input.nextInt();
            G[a].add(b);
            G[b].add(a);
        }

        dfs1(1, 1);

        for (int i = 0; i < m; i++) {
            a = input.nextInt();
            b = input.nextInt();
            int l = lca(a, b);
            sub[a]++;
            sub[b]++;
            sub[l]--;
            if (l != -1)
                sub[p[l][0]]--;
        }

        dfs2(1);

        for (int i = 1; i <= n; i++)
            System.out.print(sub[i] + " ");
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Uncomment the following line to read from an input file
        // FastReader input = new FastReader("input.txt");
        solve();
    }
}
