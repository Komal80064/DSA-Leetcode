Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u, v, w] represents the edge between the nodes u and v having w weight.
Find the shortest distance of all the vertices from the source vertex src, and return an array of integers where the ith element denotes the shortest distance between ith node and source vertex src.

Note: The Graph is connected and doesn't contain any negative weight edge.
It is guaranteed that all the shortest distance will fit in a 32-bit integer.

Examples:

Input: V = 3, edges[][] = [[0, 1, 1], [1, 2, 3], [0, 2, 6]], src = 2
Output: [4, 3, 0]
Explanation:

Shortest Paths:
For 2 to 0 minimum distance will be 4. By following path 2 -> 1 -> 0
For 2 to 1 minimum distance will be 3. By following path 2 -> 1
For 2 to 2 minimum distance will be 0. By following path 2 -> 2


Solution:-
Detailed Steps:
Create a distance array dist[] of size V and initialize all values to infinity (∞) since no paths are known yet.
Set the distance of the source vertex to 0 and insert it into the priority queue.
While the priority queue is not empty, remove the vertex with the smallest distance value.
Check: if the popped distance is greater than the recorded distance for this vertex(dist[u]), it means this vertex has already been processed with a smaller distance, so skip it and continue to the next iteration.
For each neighbor v of u, check if the path through u gives a smaller distance than the current dist[v].
If it does, update dist[v] = dist[u] + edge weight(d) and push (dist[v], v) into the priority queue.
Continue this process until the priority queue becomes empty.
Once done, the dist[] array will contain the shortest distance from the source to every vertex in the graph.
