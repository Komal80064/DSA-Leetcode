class Solution {
    int[][] directions = {{0,-1},{-1,0},{0,+1},{+1,0}};
    private void dfs(int row, int col, int[][] grid, int n, int m){
        grid[row][col] = 1;

        for(int i = 0;i<4;i++){
            int nr = row + directions[i][0];
            int nc = col + directions[i][1];
            if(nr<n && nr >= 0 && nc < m && nc >= 0 && grid[nr][nc] == 0){
                dfs(nr, nc, grid, n, m);
            }
        }
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // upper border
        for(int i=0;i<m;i++){
            if(grid[0][i] == 0){
                dfs(0, i, grid,n,m);
            }
        }
        // left border
        for(int i=0;i<n;i++){
            if(grid[i][0] == 0){
                dfs(i, 0, grid,n,m);
            }
        }
        // right border
        for(int i=0;i<n;i++){
            if(grid[i][m-1] == 0){
                dfs(i, m-1, grid,n,m);
            }
        }
        // lower border
        for(int i=0;i<m;i++){
            if(grid[n-1][i] == 0){
                dfs(n-1, i, grid,n,m);
            }
        }

        // Island
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j = 0; j < m;j++){
                if(grid[i][j] == 0){
                    count++;
                    dfs(i, j, grid,n,m);
                }
            }
        }  
        return count;      
    }
}