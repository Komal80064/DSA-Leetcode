class Solution {
    int[] row = {2,2,-2,-2,-1,-1,1,1};
    int[] col = {1,-1,1,-1,2,-2,2,-2};
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        // code here
        // convert 1-based indexing in 0-based
        knightPos[0]--;
        knightPos[1]--;
        targetPos[0]--;
        targetPos[1]--;

        // base case
        if(knightPos[0]== targetPos[0] && knightPos[1] == targetPos[1]) return 0;
      
        Queue<int[]> q = new LinkedList<>();
        boolean[][] chess = new boolean[n][n];
        
        q.add(new int[]{knightPos[0], knightPos[1]});
        chess[knightPos[0]][knightPos[1]] = true;
        
        int step = 0;
        while(!q.isEmpty()){
            int count = q.size();
            
            for(int i = 0; i < count; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                
                for(int j = 0;j < 8;j++){
                    int nr = r + row[j];
                    int nc = c + col[j];
                    
                    if(nr >= 0 && nr < n && nc >= 0 && nc < n && !chess[nr][nc]){
                        if(nr == targetPos[0] && nc == targetPos[1]) return step+1;
                        chess[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
