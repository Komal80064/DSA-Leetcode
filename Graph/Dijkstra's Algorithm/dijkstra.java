class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<int[]>>adj = new ArrayList<>();
        for(int i = 0; i< V;i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int d = edge[2];
            
            adj.get(u).add(new int[]{v,d});
            adj.get(v).add(new int[]{u,d});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[src] = 0;
        pq.add(new int[]{0, src});
        
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int d = top[0]; //distance
            int u = top[1]; // node
            
            if(d > dist[u]) continue; 
            
            for(int[] it : adj.get(u)){
                int v = it[0];
                int w = it[1];
                
                if(dist[u] + w < dist[v] ){
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int d : dist) result.add(d);
        
        return result;
    }
}
