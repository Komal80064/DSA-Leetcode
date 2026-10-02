class Solution {
    private int dfs(int node, int parent, ArrayList<ArrayList<int[]>> adj){
        int count = 0;
        
        for(int[] edge : adj.get(node)){
            int next = edge[0];
            int cost = edge[1];

            if(next == parent) continue;

            count += cost;
            count += dfs(next, node, adj);
        }
        return count;
    }
    public int minReorder(int n, int[][] connections) {
       ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] connection : connections) {

            int from = connection[0];
            int to = connection[1];

            // Original direction
            adj.get(from).add(new int[]{to, 1});

            // Reverse direction for traversal
            adj.get(to).add(new int[]{from, 0});
        }

        return dfs(0, -1, adj);
    }
}
