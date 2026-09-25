class Solution {
    public int orangesRot(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(mat[row][col] == 2){
                    q.add(new int[]{row, col});
                }
            }
        }
        
        int directions[][] = {{-1, 0}, {0,-1}, {+1,0}, {0,+1}};
        int elapsedTime = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            
            for(int i = 0; i < size; i++){
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                
                for(int dir[] : directions){
                    int nr = dir[0] + r;
                    int nc = dir[1] + c;
                    
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] == 1){
                        mat[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                        flag = true;
                    }
                }
            }
            if(flag) elapsedTime++;
        }
        
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(mat[row][col] == 1) return -1;
            }
        }
        return elapsedTime;
    }
}
