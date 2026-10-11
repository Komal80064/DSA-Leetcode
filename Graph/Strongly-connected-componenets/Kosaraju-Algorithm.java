class Solution {
    void topological(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer>s){
        visited[node] = true;
        for(int neib : adj.get(node)){
            if(!visited[neib]) topological(neib, adj, visited, s);
        }
        s.add(node);
    }
    void dfs(int node, ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        visited[node] = true;
        for(int neib : adj.get(node)){
            if(!visited[neib]) dfs(neib,adj,visited);
        }
    }
    
    public int countSCC(int V, int[][] edges) {
        // code here
        //Adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for(int i = 0; i <V;i++){
            adj.add(new ArrayList<>());
            adjRev.add(new ArrayList<>());
        }
        for(int edge[] :  edges){
            adj.get(edge[0]).add(edge[1]);
            adjRev.get(edge[1]).add(edge[0]); // Reverse the edges // Transpose the graph
        }
        //Topological sort
        Stack<Integer>s = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V;i++){
            if(!visited[i]) topological(i, adj, visited, s);
        }
       
        //Pop the element from stack
            //if the poped  node is not visited yet
            //ssc++
            //dfs
        for(int i = 0;i< V;i++)visited[i] = false;
        int scc = 0;
        while(!s.isEmpty()){
            int node = s.pop();
            if(!visited[node]){
                scc++;
                dfs(node,adjRev,visited);
            }
        }
        return scc;
    }
}
