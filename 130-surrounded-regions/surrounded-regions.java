class Solution {
    int delrow[] = {-1, 0,+1, 0};
    int delcol[] = {0, -1,0, +1};

    public void dfs(int row , int col , char[][] board, int[][] vis){
        vis[row][col] =1;
        int n = board.length;
        int m = board[0].length;

        for(int i = 0;i < 4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O' ) dfs(nrow, ncol, board, vis);
        }


    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];

        for(int i = 0; i < m; i++){
            if(board[0][i] == 'O' && vis[0][i]==0) dfs(0, i, board, vis);
            if(board[n-1][i] == 'O' && vis[n-1][i] ==0) dfs(n-1, i, board, vis);
        }

        for(int i = 0; i< n;i++){
            if(board[i][0] == 'O' && vis[i][0] == 0) dfs(i, 0, board, vis);
            if(board[i][m-1] == 'O' && vis[i][m-1]==0) dfs(i, m-1, board, vis);

        }

        for(int i = 0;i< n;i++){
            for(int j = 0;j<m;j++){
                if(vis[i][j] == 0 && board[i][j] == 'O') board[i][j] ='X';
            }
        }
    }

}