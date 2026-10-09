class Solution {
    private void dfs(int node, boolean[] visited, int[][] adj){
        visited[node] = true;
        for(int neighbour: adj[node]){
            if(!visited[neighbour]){
                dfs(neighbour, visited, adj);
            }
        }
    }
    public int isEulerCircuit(int V, int[][] adj) {
        // code here
        int[] deg = new int[V];
        
        int odd = 0;
        for(int i = 0;i < V;i++){
            int size = adj[i].length;
            deg[i] = size;
            if(size%2 != 0) odd++;
        }
        
        if(odd != 0 && odd != 2) return 0;
        
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(deg[i]  != 0){
                dfs(i, visited, adj);
                break;
            }
        }
        
        for(int i = 0; i < V;i++){
            if(deg[i] != 0 && !visited[i]) return 0;
        }
        
        return odd==0 ? 2 : 1;
    }
}
