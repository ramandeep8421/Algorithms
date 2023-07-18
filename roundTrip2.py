import java.util.*;
import java.io.*;

class Main {
    static boolean isCycle(int node, int[] vis, int[] recStack, Stack<Integer> st, List<Integer>[] adj) {
        vis[node] = recStack[node] = 1;
        st.push(node);

        for (int neighbor : adj[node]) {
            if (vis[neighbor] == 0) { // include it into the cycle
                if (isCycle(neighbor, vis, recStack, st, adj)) {
                    return true;
                }
            } else if (recStack[neighbor] == 1) {
                // back-edge
                st.push(neighbor);
                return true;
            }
        }

        recStack[node] = 0;
        st.pop();
        return false;
    }

    static List<Integer> extract(Stack<Integer> st) {
        int node = st.peek();
        List<Integer> cycle = new ArrayList<>();
        cycle.add(node);
        st.pop();

        while (!st.empty()) {
            cycle.add(st.peek());
            if (st.peek() == node) {
                break;
            }
            st.pop();
        }

        return cycle;
    }

    // just detect if there is a cycle or not
    static List<Integer> roundTrip(int n, List<Integer>[] adj) {
        int[] vis = new int[n + 1];
        int[] recStack = new int[n + 1];
        Stack<Integer> st = new Stack<>();

        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {
                if (isCycle(i, vis, recStack, st, adj)) {
                    return extract(st);
                }
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        List<Integer>[] adj = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            adj[a].add(b);
        }

        List<Integer> cycle = roundTrip(n, adj);

        if (cycle.size() == 0) {
            pw.println("IMPOSSIBLE");
            pw.close();
            return;
        }

        Collections.reverse(cycle);
        pw.println(cycle.size());
        for (int it : cycle) {
            pw.print(it + " ");
        }

        pw.close();
    }
}
