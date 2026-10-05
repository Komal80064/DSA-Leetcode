Shortest Path with Lexicographically Smallest Path — Approach
Step 1: Build the graph

Create an undirected weighted adjacency list because every edge [u, v, w] works in both directions.

Step 2: Run Dijkstra from dest

Instead of running Dijkstra from src, start from dest.

Store:

dist[u] = shortest distance from u to dest

This tells us the minimum remaining cost from every node to the destination.

Step 3: Check if destination is reachable

If:

dist[src] == INF

then no path exists, so return:

[-1]
Step 4: Construct the path from src

Start:

current = src

For every neighbor v of current with edge weight w, check:

dist[current] == w + dist[v]

If true, then:

current → v

can be part of a shortest path.

Step 5: Choose the smallest valid neighbor

If multiple neighbors satisfy the condition, choose the smallest vertex number.

Why?

Because the problem asks for the lexicographically smallest path.

Step 6: Repeat

Move to the selected neighbor and repeat until reaching dest.

Key idea to remember
Dijkstra → finds shortest distances
Greedy   → chooses lexicographically smallest shortest path
Most important condition
dist[current] == weight + dist[neighbor]

means:

This edge keeps us on a shortest path.

Then:

choose smallest neighbor

gives the lexicographically smallest shortest path.

Complexity
Time  : O((V + E) log V)
Space : O(V + E)
