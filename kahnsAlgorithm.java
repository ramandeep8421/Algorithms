import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long max(long a, long b) {
        return (a > b) ? a : b;
    }

    public int dfs(int mid, int node, int par, ArrayList<ArrayList<Integer>> graph, int[] wt, int[] tot, int c) {
        tot[node] = wt[node];

        ArrayList<Integer> arr = new ArrayList<>();

        for (int it : graph.get(node)) {
            if (it != par) {
                arr.add(dfs(mid, it, node, graph, wt, tot, c));
            }
        }

        Collections.sort(arr);

        for (int it : arr) {
            if (tot[node] + it > mid) {
                c++;
            } else {
                tot[node] += it;
            }
        }

        return tot[node];
    }

    public long minimumWeightSubtree(int[] wt, ArrayList<ArrayList<Integer>> graph, int n, int k) {
        int[] tot = new int[n + 1];

        long mn = -1, mx = 0;

        for (int it : wt) {
            mn = max(mn, it);
            mx += it;
        }

        long ans;
        long lo = mn, hi = mx;

        int c = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            dfs(mid, 1, 0, graph, wt, tot, c);

            if (c <= k - 1) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }
}
