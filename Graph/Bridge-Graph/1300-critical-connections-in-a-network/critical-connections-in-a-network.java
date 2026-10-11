class Solution {
    private void dfs(int node,int parent,ArrayList<ArrayList<Integer>>adj,int[] disc,int[] low,boolean[] visited,List<List<Integer>> bridges,int count){
        disc[node] = low[node] = count;
        visited[node] = true;

        for(int neib : adj.get(node)){
            if(neib == parent) continue; //Ignore parent
            else if(visited[neib]) low[node] = Math.min(low[node],low[neib]);
            else{
                count++;
                dfs(neib,node,adj,disc,low,visited,bridges,count);
                //Bridge exist
                if(low[neib] > disc[node]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(node);
                    temp.add(neib);
                    bridges.add(temp);
                }
                low[node] = Math.min(low[node], low[neib]);
            } 
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n;i++)adj.add(new ArrayList<>());
        for(List<Integer> l : connections){
            int u = l.get(0);
            int v = l.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<List<Integer>> bridges = new ArrayList<>();
        int[] disc = new int[n]; // discovery time
        int[] low = new int[n]; // low time

        boolean[] visited = new boolean[n];
        int count = 0;
        dfs(0,-1,adj,disc,low,visited,bridges,count);

        return bridges;
    }
}