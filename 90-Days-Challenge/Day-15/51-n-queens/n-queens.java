class Solution {
    private void find(int row, int n, List<List<String>> ans, List<String> board, boolean[] column, boolean[] leftDign, boolean[] rightDign){
        // Base condition
        if(row == n){
            ans.add(new ArrayList<>(board));
            return;
        } 
        // Put queen at any n position
        for(int i = 0; i < n; i++){
            if(!column[i] && !rightDign[row+i] && !leftDign[n-1+i-row]){
                column[i] = true;
                rightDign[row+i] = true;
                leftDign[n-1+i-row] = true;

                // Place queen
                StringBuilder s = new StringBuilder(board.get(row));
                s.setCharAt(i, 'Q');
                board.set(row, s.toString());
                //Move to next row
                find(row+1, n, ans, board, column, leftDign, rightDign);
                // Backtrack: remove queen
                column[i] = false;
                rightDign[row+i] = false;
                leftDign[n-1+i-row] = false;
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(i, '.');
                board.set(row, sb.toString());
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        // Initialize empty board
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n;j++) sb.append('.');
            board.add(sb.toString());
        }
        
        boolean[]  column = new boolean[n];
        boolean[] leftDign = new boolean[n*2-1];
        boolean[] rightDign = new boolean[n*2-1];

        find(0,n,ans,board,column,leftDign,rightDign);

        return ans;
    }
}