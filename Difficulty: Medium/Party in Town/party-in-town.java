import java.util.*;

class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        if (n <= 1) return 0;

        // Step 1: Find one endpoint of the diameter (farthest from node 1)
        int[] result1 = bfs(1, adj, n);
        int endpointA = result1[0];

        // Step 2: Find the diameter length starting from endpointA
        int[] result2 = bfs(endpointA, adj, n);
        int diameter = result2[1];

        // Minimum maximum distance is ceil(diameter / 2)
        return (diameter + 1) / 2;
    }

    private int[] bfs(int start, ArrayList<ArrayList<Integer>> adj, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        dist[start] = 0;

        int farthestNode = start;
        int maxDist = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (dist[curr] > maxDist) {
                maxDist = dist[curr];
                farthestNode = curr;
            }

            // 1-based indexing for adj: adj[i] corresponds to house i + 1
            for (int neighbor : adj.get(curr - 1)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[curr] + 1;
                    q.add(neighbor);
                }
            }
        }

        return new int[]{farthestNode, maxDist};
    }
}