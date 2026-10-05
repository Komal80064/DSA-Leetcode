class Solution {
    public ArrayList<Integer> shortestPath(int V, int[][] edges, int src, int dest) {

        // Build adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        // ------------------------------------
        // Step 1: Dijkstra from destination
        // ------------------------------------

        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        dist[dest] = 0;
        pq.add(new int[]{0, dest});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int distance = curr[0];
            int node = curr[1];

            // Ignore outdated entry
            if (distance != dist[node]) {
                continue;
            }

            for (int[] edge : adj.get(node)) {

                int neighbour = edge[0];
                int weight = edge[1];

                if (dist[node] + weight < dist[neighbour]) {

                    dist[neighbour] = dist[node] + weight;

                    pq.add(new int[]{
                        dist[neighbour],
                        neighbour
                    });
                }
            }
        }

        // ------------------------------------
        // Step 2: Destination unreachable
        // ------------------------------------

        if (dist[src] == Integer.MAX_VALUE) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(-1);
            return ans;
        }

        // ------------------------------------
        // Step 3: Construct lexicographically
        //         smallest shortest path
        // ------------------------------------

        ArrayList<Integer> path = new ArrayList<>();

        int current = src;
        path.add(current);

        while (current != dest) {

            int next = -1;

            for (int[] edge : adj.get(current)) {

                int neighbour = edge[0];
                int weight = edge[1];

                // Can this neighbour continue
                // a shortest path to destination?
                if (dist[current] == weight + dist[neighbour]) {

                    if (next == -1 || neighbour < next) {
                        next = neighbour;
                    }
                }
            }

            current = next;
            path.add(current);
        }

        return path;
    }
}
