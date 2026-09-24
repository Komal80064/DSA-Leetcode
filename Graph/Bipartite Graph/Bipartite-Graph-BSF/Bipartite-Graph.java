class Solution {
    public boolean isBipartite(int V, int[][] edges) {
         // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert edge list -> adjacency list
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] color = new int[V];
        for(int i = 0;i < V; i++) color[i] = -1;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                q.offer(i);
                color[i] = 0;
                
                while(!q.isEmpty()){
                    int u = q.poll();
                    
                    for(int it : adj.get(u)){
                        if(color[it] == -1){
                            color[it] = 1-color[u];
                            q.offer(it);
                        }
                        else if(color[it] == color[u]) return false;
                    }
                }
            }
        }
        return true;
    }
}
