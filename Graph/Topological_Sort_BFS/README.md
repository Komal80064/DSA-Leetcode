The idea is to use Kahn’s Algorithm, which applies BFS to generate a valid topological ordering.
 We first compute the in-degree of every vertex — representing how many incoming edges each vertex has. Then, all vertices with an in-degree of 0 are added to a queue, as they can appear first in the ordering.
 We repeatedly remove a vertex from the queue, add it to our result list, and reduce the in-degree of all its adjacent vertices. If any of those vertices now have an in-degree of 0, they are added to the queue.
 This process continues until the queue is empty, and the resulting order represents one valid topological sort of the graph.
