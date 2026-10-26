class Solution {
    int[][] directions = {{-1,0},{0,+1},{+1,0},{0,-1}};
    private void dfs(int row, int col, long[] sum, int[][] grid, int n, int m){
        sum[0] += grid[row][col];
        grid[row][col] = 0;

        for(int[] direction : directions){
            int nr = row + direction[0];
            int nc = col + direction[1];
            if(nr>=0 && nr<n && nc >= 0 && nc < m && grid[nr][nc] != 0){
                dfs(nr,nc,sum,grid,n,m);
            }
        } 
    }
    public int countIslands(int[][] grid, int k) {
        int n =  grid.length;
        int m = grid[0].length;
      
        int count = 0;


        for(int i =0;i<n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] != 0){
                    long[] sum = {0};
                    dfs(i,j,sum,grid,n,m);
                    if(sum[0]%k==0)count++;
                
                }
            }
        }
        return count;
    }
}