class Solution {
    static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node]= true;
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]) dfs(neighbour, visited, adj);
        }
    }
    static boolean isCircle(String arr[]) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 26; i++) adj.add(new ArrayList<>());
        
        int[] inDeg = new int[26];
        int[] outDeg = new int[26];
        for(String s : arr){
            int first = s.charAt(0)-'a';
            int last = s.charAt(s.length()-1)-'a';
            adj.get(first).add(last);
            
            inDeg[last]++;
            outDeg[first]++;
        }
        
        for(int i = 0;i< 26;i++){
            if(inDeg[i] != outDeg[i]) return false;
        }
        
        boolean[] visited = new boolean[26];
        dfs(arr[0].charAt(0)-'a', visited, adj);
        
        for(int i=0;i<26;i++){
            if(inDeg[i] > 0 && !visited[i]) return false;
        }
        
        return true;
    }
}
