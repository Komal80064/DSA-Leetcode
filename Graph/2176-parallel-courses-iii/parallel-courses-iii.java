class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n;i++) adj.add(new ArrayList<>());
        int[] inDegree = new int[n];
        for(int relation[] : relations){
            int u = relation[0]-1;
            int v = relation[1]-1;
            adj.get(u).add(v);
            inDegree[v]++;
        }
        int ans  = 0;
        int[] month = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                q.offer(i);
                month[i] = time[i];
                ans = Math.max(ans, month[i]);
            } 
        }
        
        while(!q.isEmpty()){
            int node = q.poll();

            for(int neighbour : adj.get(node)){
                // Update earliest starting time
                month[neighbour] = Math.max(month[neighbour], month[node] + time[neighbour]);
                ans = Math.max(ans, month[neighbour]);
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) q.offer(neighbour);
            }
        }
        // int ans  = 0;
        // for(int i = 0; i < n; i++){
        //     ans = Math.max(ans, month[i] + time[i]);
        // }
        return ans;
    }
}