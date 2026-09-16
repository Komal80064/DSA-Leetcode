// BFS SOLUTION
// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int n = image.length;
//         int m = image[0].length;
//         int initial = image[sr][sc];
//         boolean[][] visited = new boolean[n][m];
//         visited[sr][sc] = true;
//         image[sr][sc] = color;
//         solve(image, sr, sc, color, n, m, initial, visited);
//         return image;

//     }

//     public void solve(int[][] image, int i, int j, int color, int n, int m, int initial, boolean[][] visited){
//         Queue<int[]> q = new LinkedList<>();
//         q.add(new int[]{i,j});
//         while(!q.isEmpty()){
//             int[] u = q.poll();
//             int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
//             for(int[] dir: directions){
//                 int nr = u[0] + dir[0];
//                 int nc = u[1] + dir[1];
//                 if(nr >= 0 && nc >= 0 && nr<n && nc < m && image[nr][nc] == initial && visited[nr][nc] == false){
//                     visited[nr][nc] = true;
//                     image[nr][nc] = color;
//                     q.add(new int[]{nr, nc});
//                 }
//             }
//         }
//     }
// }

//DFS SOLUTION
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        // If the color is already the target color
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int color) {
        // Out of bounds
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
            return;
        }

        // Only fill pixels with the original color
        if (image[r][c] != originalColor) {
            return;
        }

        // Change the color
        image[r][c] = color;

        
        dfs(image, r + 1, c, originalColor, color); // Down
        dfs(image, r - 1, c, originalColor, color); // Up
        dfs(image, r, c + 1, originalColor, color); // Right
        dfs(image, r, c - 1, originalColor, color); // Left
    }
}