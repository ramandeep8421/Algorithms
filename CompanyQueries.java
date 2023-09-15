import java.util.*;
import java.io.*;

public class Main {
    static final int MAXN = 200011;
    static final int M = 20;

    static ArrayList<ArrayList<Integer>> up = new ArrayList<>(MAXN);
    static ArrayList<Integer> level = new ArrayList<>(MAXN);

    static void init() {
        fast_io();
        #ifndef ONLINE_JUDGE
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        } catch (Exception e) {}
        #endif
    }

    static void fast_io() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            int n = Integer.parseInt(br.readLine().trim());
            int q = Integer.parseInt(br.readLine().trim());

            ArrayList<Integer>[] adj = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 2; i <= n; i++) {
                int a = Integer.parseInt(br.readLine().trim());
                adj[i].add(a);
                adj[a].add(i);
            }

            dfs(1, -1, adj, 0);
            preprocess();

            while (q-- > 0) {
                String[] query = br.readLine().trim().split(" ");
                int x = Integer.parseInt(query[0]);
                int k = Integer.parseInt(query[1]);

                if (level.get(x) < k) {
                    pw.println(-1);
                    continue;
                }

                while (k > 0) {
                    int i = (int) (Math.log(k) / Math.log(2));
                    x = up.get(x).get(i);
                    if (x == -1)
                        break;
                    k -= (1 << i);
                }

                pw.println(x);
            }

            pw.flush();
        } catch (Exception e) {}
    }

    static void dfs(int node, int par, ArrayList<Integer>[] adj, int lvl) {
        up.get(node).set(0, par);
        level.set(node, lvl);

        for (int child : adj[node]) {
            if (child != par) {
                dfs(child, node, adj, lvl + 1);
            }
        }
    }

    static void preprocess() {
        for (int i = 1; i < MAXN; i++) {
            for (int j = 1; j < M; j++) {
                if (up.get(i).get(j - 1) != -1) {
                    int par = up.get(i).get(j - 1);
                    up.get(i).set(j, up.get(par).get(j - 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        init();
    }
}
