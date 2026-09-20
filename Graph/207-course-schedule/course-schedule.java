// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

//         for (int[] pre : prerequisites)
//             adj.get(pre[1]).add(pre[0]);

            
//         boolean[] vis = new boolean[numCourses];
//         boolean[] path = new boolean[numCourses];

//         for (int i = 0; i < numCourses; i++)
//             if (!vis[i] && dfs(i, adj, vis, path)) return false;

//         return true;
//     }

//     private boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] path) {
//         vis[node] = path[node] = true;

//         for (int next : adj.get(node))
//             if (!vis[next] && dfs(next, adj, vis, path)) return true;
//             else if (path[next]) return true;
            
//         path[node] = false;
//         return false;
//     }
// }

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i< numCourses; i++) adj.add(new ArrayList<>());

        int indegree[] = new int[numCourses];
        for(int[] pre: prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i< numCourses;i++){
            if(indegree[i] == 0) q.offer(i);
        }

        
        int idx = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            idx++;

            for(int it : adj.get(curr)){
                indegree[it]--;
                if(indegree[it] == 0) q.offer(it);
            }
        }
        if(idx != numCourses) return false;

        return true;
    }
}