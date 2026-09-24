class Solution {
    private void dfs(int node, boolean[] vis, Stack<Integer> st,  ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        
        for(int it : adj.get(node)){
            if(!vis[it]) dfs(it, vis, st, adj);
        }
        
        st.add(node);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i<V; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
        
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < V; i++){
            if(!vis[i]) dfs(i, vis, st, adj);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        
        return ans;
    }
}
