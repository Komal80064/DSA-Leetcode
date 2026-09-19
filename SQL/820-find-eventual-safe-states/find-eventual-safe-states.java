class Solution {
    private boolean dfsCheck(int node, int[][] graph, int[] vis, int[] pathVis, int[] check){
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for(int it : graph[node]){
            if(vis[it] == 0){
                if(dfsCheck(it, graph, vis, pathVis, check) == true){
                    return true;
                }
            }
            else if(pathVis[it] == 1){
                return true;
            }
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        int vis[] = new int[n];
        int pathVis[] = new int[n];
        int check[] = new int[n];

        List<Integer> safeNodes = new ArrayList<>();

        for(int i = 0; i<n; i++){
            if(vis[i] == 0){
                dfsCheck(i, graph, vis, pathVis, check);
            }
        }
        for(int i = 0; i < n; i++){
            if(pathVis[i] == 0) safeNodes.add(i);
        }
        return safeNodes;
    }
}