class Solution {

    public void dfs(int row , int col ,int n, int m, char[][] board, int[][] vis){
        if(row >= n || row < 0 || col >= m || col < 0 || vis[row][col] == 1 || board[row][col] == 'X') return;

        vis[row][col] = 1;

        dfs(row-1, col, n, m, board, vis);
        dfs(row, col-1, n, m, board, vis);
        dfs(row+1, col, n, m, board, vis);
        dfs(row, col+1, n, m, board, vis);

    }

    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;

        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];

        for(int i = 0; i < m; i++){
            if(board[0][i] == 'O' && vis[0][i]==0) dfs(0, i, n, m, board, vis);
            if(board[n-1][i] == 'O' && vis[n-1][i] ==0) dfs(n-1, i, n, m, board, vis);
        }

        for(int i = 0; i< n;i++){
            if(board[i][0] == 'O' && vis[i][0] == 0) dfs(i, 0, n, m, board, vis);
            if(board[i][m-1] == 'O' && vis[i][m-1]==0) dfs(i, m-1, n, m, board, vis);

        }

        for(int i = 0;i< n;i++){
            for(int j = 0;j<m;j++){
                if(vis[i][j] == 0 && board[i][j] == 'O') board[i][j] ='X';
            }
        }
    }

}