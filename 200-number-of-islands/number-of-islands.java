class Solution {
    final int diff[][]={{0,-1},{0,1},{-1,0},{1,0}};
    // class Pair {
    //     int first;
    //     int second;
    //     public Pair(int first, int second) {
    //         this.first = first;
    //         this.second = second;
    //     }
    // }

    // private void bfs(int row, int col, char[][] grid, int[][] visited) {
    //     visited[row][col] = 1;
    //     Queue<Pair> q = new LinkedList<>();
    //     q.add(new Pair(row, col));
    //     int n = grid.length;
    //     int m = grid[0].length;

    //     // Direction arrays for 4-directional traversal: Up, Right, Down, Left
    //     int[] dRow = {-1, 0, 1, 0};
    //     int[] dCol = {0, 1, 0, -1};

    //     while (!q.isEmpty()) {
    //         Pair current = q.poll();
    //         int r = current.first;
    //         int c = current.second;

    //         for (int i = 0; i < 4; i++) {
    //             int nrow = r + dRow[i];
    //             int ncol = c + dCol[i];

    //             if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
    //                     && visited[nrow][ncol] != 1 && grid[nrow][ncol] == '1') {
    //                 visited[nrow][ncol] = 1;
    //                 q.add(new Pair(nrow, ncol));
    //             }
    //         }
    //     }
    // }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    dfs(grid, n, m, row, col);
                }
            }
        }
        return count;
    }

    
    private void dfs(char[][] grid, int R, int C, int row, int col){
        grid[row][col]='0';
        for(int i=0; i<4; i++){
            int ar=row+diff[i][0], ac=col+diff[i][1];
            if(ar>=0 && ar<R && ac>=0 && ac<C && grid[ar][ac]=='1'){
                dfs(grid, R, C, ar, ac);
            }
        }
    }
}