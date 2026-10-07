class Solution {
    int[] row = {-1, 0, +1, 0};
    int col[] = {0, -1, 0 , +1};
    public int shortestPath(int[][] mat, int[] src, int[] dest) {
        
        if(mat[src[0]][src[1]] == 0 || mat[dest[0]][dest[1]] == 0) return -1;
        if(src[0] == dest[0] && src[1] == dest[1]) return 0;
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src[0], src[1]});
        
        mat[src[0]][src[1]] = 0;
        int step = 0;
        
        while(!q.isEmpty()){
            int count = q.size();
            
            for(int i = 0; i < count;i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
            
                for(int j = 0; j < 4;j++){
                    int nr = r + row[j];
                    int nc = c + col[j];
                
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] == 1){
                        if(nr == dest[0] && nc == dest[1]) return step+1;
                    
                        mat[nr][nc] = 0;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            step++;
        }
        
        return -1;
    }
}
