class Solution {
    ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            indegree[v]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            
            for(int it : adj.get(curr)){
                indegree[it]--;
                if(indegree[it] == 0) q.offer(it);
            }
        }
        
        return ans;
        
    }
}
