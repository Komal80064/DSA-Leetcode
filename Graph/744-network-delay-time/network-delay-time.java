class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for(int[] time: times){
            int u =  time[0];
            int v = time[1];
            int w = time[2];

            adj.get(u).add(new int[]{v,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        pq.add(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int dis = curr[0];
            int node = curr[1];

            if(dis > dist[node]) continue;

            for(int[] neighbours: adj.get(node)){
                int neighbour = neighbours[0];
                int w = neighbours[1];

                if(dist[node] + w < dist[neighbour]){
                    dist[neighbour] = dist[node]+w;
                    pq.add(new int[]{dist[neighbour] , neighbour});
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}