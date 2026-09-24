Working of Approach:

Create an adjacency list from the given edges.
Start BFS from every unvisited vertex to handle disconnected graphs.
Assign the starting vertex color 0 and color every neighbor with the opposite color.
If an already colored neighbor has the same color as the current vertex, return false.
If BFS finishes without any conflict, return true.
