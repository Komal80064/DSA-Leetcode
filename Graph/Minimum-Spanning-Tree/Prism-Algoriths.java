class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<int[]>>adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0,0,-1});
        
        boolean[] isMST = new boolean[V];
        int parent[] = new int[V];
        
        int cost = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int wt = curr[0];
            int node = curr[1];
            int par = curr[2];
            
            if(!isMST[node]){
                isMST[node] = true;
                cost += wt;
                parent[node] = par;
                
                for(int[] neighbours : adj.get(node)){
                    int neighbour = neighbours[0];
                    int nwt = neighbours[1]; 
                    
                    if(!isMST[neighbour]){
                        pq.add(new int[]{nwt, neighbour, node});
                    }
                }
            }
        }
        return cost;
    }
}
