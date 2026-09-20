class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] topo = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            topo[idx++] = curr;

            for(int it : adj.get(curr)){
                indegree[it]--;
                if(indegree[it] == 0) q.offer(it);
            }
        }
        if(idx != numCourses) return new int[0];

        return topo;
    }
}