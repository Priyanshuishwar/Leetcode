class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int vis[][] = new int[n][m];
        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };

        for (int j = 0; j < m; j++) {
            if (vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, vis, board, drow, dcol);
            }
            if (vis[n - 1][j] == 0 && board[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, board, drow, dcol);
            }
        }
        for (int i = 0; i < n; i++) {
            if (vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, vis, board, drow, dcol);
            }
            if (vis[i][m - 1] == 0 && board[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, board, drow, dcol);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(int row, int col, int vis[][], char board[][], int dirow[], int dicol[]) {
        int n = board.length;
        int m = board[0].length;
        vis[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int nrow = dirow[i] + row;
            int ncol = dicol[i] + col;

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, board, dirow, dicol);
            }
        }

    }
}