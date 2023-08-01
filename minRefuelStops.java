import java.util.PriorityQueue;
import java.util.List;

class Solution {
    public int minRefuelStops(int target, int tank, List<int[]> stations) {
        int ans = 0, prev = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int[] station : stations) {
            int location = station[0];
            int fuel = station[1];

            int d = location - prev;

            tank -= d;

            while (!pq.isEmpty() && tank < 0) {
                tank += pq.poll();
                ans++;
            }

            if (tank < 0) return -1;

            prev = location;
            pq.offer(fuel);
        }

        tank -= (target - prev);

        while (!pq.isEmpty() && tank < 0) {
            tank += pq.poll();
            ans++;
        }

        if (tank < 0) return -1;

        return ans;
    }
}
