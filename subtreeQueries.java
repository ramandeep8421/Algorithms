import java.io.*;
import java.util.*;

public class Main {
    static final int MAXN = 200011;
    static ArrayList<Integer>[] adj = new ArrayList[MAXN];
    static ArrayList<Integer> sub = new ArrayList<>(Collections.nCopies(MAXN, 1));
    static int n, timer = 0;
    static int[] t = new int[4 * MAXN];
    static int[] start = new int[MAXN];
    static int[] value = new int[MAXN];
    static int[] arr = new int[MAXN];

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = 1; // Number of test cases
        // t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }

    static void init() {
        for (int i = 0; i < MAXN; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
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
            try {
                return br.readLine();
            } catch (IOException e) {
                return null;
            }
        }
    }

    static void build(int v, int tl, int tr) {
        if (tl == tr) {
            t[v] = arr[tl];
            return;
        }
        int tm = (tl + tr) / 2;
        build(v * 2, tl, tm);
        build(v * 2 + 1, tm + 1, tr);
        t[v] = t[v * 2] + t[v * 2 + 1];
    }

    static void update(int v, int tl, int tr, int pos, int new_val) {
        if (tl == tr) {
            t[v] = new_val;
        } else {
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                update(v * 2, tl, tm, pos, new_val);
            else
                update(v * 2 + 1, tm + 1, tr, pos, new_val);
            t[v] = t[v * 2] + t[v * 2 + 1];
        }
    }

    static int sum(int v, int tl, int tr, int l, int r) {
        if (l > r)
            return 0;
        if (l == tl && r == tr) {
            return t[v];
        }
        int tm = (tl + tr) / 2;
        return sum(v * 2, tl, tm, l, Math.min(r, tm))
                + sum(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r);
    }

    static void dfs(int node, int par) {
        start[node] = ++timer;
        arr[start[node]] = value[node];
        for (int child : adj[node]) {
            if (child != par) {
                dfs(child, node);
                sub.set(node, sub.get(node) + sub.get(child));
            }
        }
    }

    static void solve(FastScanner sc) {
        int q;
        n = sc.nextInt();
        q = sc.nextInt();
        init();

        for (int i = 1; i <= n; i++) {
            value[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        dfs(1, -1);
        build(1, 1, n);

        while (q-- > 0) {
            int t = sc.nextInt();
            if (t == 1) {
                int s, x;
                s = sc.nextInt();
                x = sc.nextInt();
                update(1, 1, n, start[s], x);
                arr[start[s]] = x;
            } else {
                int s;
                s = sc.nextInt();
                System.out.println(sum(1, 1, n, start[s], start[s] + sub.get(s) - 1));
            }
        }
    }
}
