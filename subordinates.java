import java.io.*;
import java.util.*;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

    static class CustomHash {
        static long splitmix64(long x) {
            x += 0x9e3779b97f4a7c15L;
            x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9L;
            x = (x ^ (x >> 27)) * 0x94d049bb133111ebL;
            return x ^ (x >> 31);
        }

        public long hashCode(long x) {
            final long FIXED_RANDOM = System.nanoTime();
            return splitmix64(x + FIXED_RANDOM);
        }
    }

    static class Pair {
        long first, second;

        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    static class TreeOrderStatisticsNodeUpdate extends Pair {
        public TreeOrderStatisticsNodeUpdate(long first, long second) {
            super(first, second);
        }
    }

    static class Tree extends TreeSet<Long> {
        public long order_of_key(long key) {
            return headSet(key).size();
        }

        public long find_by_order(long k) {
            Iterator<Long> it = iterator();
            long ans = 0;
            while (k-- > 0 && it.hasNext()) {
                ans = it.next();
            }
            return ans;
        }
    }

    static void YES() {
        System.out.println("YES");
    }

    static void NO() {
        System.out.println("NO");
    }

    static long Bexp(long a, long b) {
        long ret = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ret = ret * a;
            }
            a = a * a;
            b >>= 1;
        }
        return ret;
    }

    static long gcd(long A, long B) {
        if (B == 0)
            return A;
        return gcd(B, A % B);
    }

    static long min(long a, long b) {
        return a > b ? b : a;
    }

    static long max(long a, long b) {
        return a > b ? a : b;
    }

    static long mod(long a, long b) {
        return (((a % b) + b) % b);
    }

    static boolean is_odd(long n) {
        return (n & 1) != 0;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = 1;
        // t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            solve(test, sc);
        }
    }

    static void dfs(int node, int parent, List<Integer>[] adj, long[] dp) {
        for (int it : adj[node]) {
            if (it != parent) {
                dfs(it, node, adj, dp);
                dp[node] += dp[it];
            }
        }
    }

    static void solve(int test, FastReader sc) {
        int n = sc.nextInt();
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            x--;
            adj[x].add(i);
            adj[i].add(x);
        }

        long[] dp = new long[n];
        dfs(0, -1, adj, dp);
        for (int i = 0; i < n; i++) {
            System.out.print((dp[i] - 1) + " ");
        }
    }
}
