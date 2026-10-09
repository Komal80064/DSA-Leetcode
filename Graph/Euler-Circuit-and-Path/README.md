Euler Circuit and Path

An Eulerian Path is a path in graph that visits every edge exactly once. An Eulerian Circuit is an Eulerian Path which starts and ends on the same vertex.

Given an undirected graph as adjacency list adj , where adj[i] stores all the nodes that have an edge with i,

Return 2 if the graph contains an eulerian circuit.
Else if the graph contains an eulerian path, return 1.
Otherwise, return 0.
Examples

Input: 

Output: 2
Explanation: 
Following is an eulerian circuit in the mentioned graph
1 -> 2 -> 0 -> 1
Input: 

Output: 1
Explanation: 
Following is an eulerian path in the mentioned graph
1 -> 0 -> 2
Constraints:
1 ≤ V, E ≤ 104
0 ≤ adj[i][j] ≤ V-1
