class Solution {
    void dfs(int node, int[][] adj,boolean visited[], int[] disc, int[] low, Stack<Integer>s, boolean[] inStack, ArrayList<ArrayList<Integer>> ans, int[] timer){
        visited[node] = true;
        disc[node] = low[node] = timer[0]++;
        s.push(node);
        inStack[node] = true;
        
        for(int neib : adj[node]){
            if(!visited[neib]){
                dfs(neib, adj, visited, disc, low, s, inStack,ans, timer);
                
                low[node] = Math.min(low[node], low[neib]);
            }else{
                //check if it is present in stack or not
                if(inStack[neib]) low[node] = Math.min(low[node], disc[neib]);
            }
        }
        if(disc[node] == low[node]){
            ArrayList<Integer> temp = new ArrayList<>();
            while(!s.isEmpty() && s.peek() != node){
                int top = s.pop();
                temp.add(top);
                inStack[top] = false;
            }
            temp.add(node);
            inStack[node] = false;
            s.pop();
            Collections.sort(temp);
            ans.add(temp);
        }
    }
    public ArrayList<ArrayList<Integer>> tarjans(int V, int[][] adj) {
        // code here
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] visited= new boolean[V];
        Stack<Integer> s = new Stack<>();
        boolean[] inStack = new boolean[V];
        int[] timer = {0};
        
        for(int i = 0; i < V;i++){
            if(!visited[i]) dfs(i, adj, visited, disc, low, s, inStack, ans, timer);
        }
        Collections.sort(ans, (a, b) -> a.get(0) - b.get(0));
        return ans;
    }
}
