import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        // adjacency list to represent the given graph
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // red edges are represented by 0
        for (int[] redEdge : redEdges) {
            adj.get(redEdge[0]).add(new Pair<>(redEdge[1], 0));
        }

        // blue edges are represented by 1
        for (int[] blueEdge : blueEdges) {
            adj.get(blueEdge[0]).add(new Pair<>(blueEdge[1], 1));
        }

        // declare an answer array
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        // declare the visited array
        boolean[][] visited = new boolean[n][2];

        // declare an empty queue
        Queue<int[]> q = new LinkedList<>();

        // insert the first tuple
        // starting with node 0, with number of steps as 0 and undefined color -1
        q.add(new int[] {0, 0, -1});

        // initialize the visited array
        visited[0][0] = visited[0][1] = true;

        // initialize the answer array
        answer[0] = 0;

        while (!q.isEmpty()) {
            int[] element = q.poll();
            int node = element[0], steps = element[1], prevColor = element[2];

            for (Pair<Integer, Integer> neighbor : adj.get(node)) {
                int neighborNode = neighbor.getKey(), color = neighbor.getValue();
                if (!visited[neighborNode][color] && color != prevColor) {
                    visited[neighborNode][color] = true;
                    q.add(new int[] {neighborNode, 1 + steps, color});
                    if (answer[neighborNode] == -1) {
                        answer[neighborNode] = 1 + steps;
                    }
                }
            }
        }
        return answer;
    }
}
