class Solution {
public boolean exist(char[][] board, String word) {
    int n = board.length, m = board[0].length;
    boolean[][] vis = new boolean[n][m];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (board[i][j] == word.charAt(0)) {
                vis[i][j] = true;
                if (helper(board, word, i, j, vis, 0)) return true;
                vis[i][j] = false;
            }
        }
    }
    return false;
}


    public static boolean helper(char board[][], String word, int row, int col, boolean vis[][], int curr) {
        if (curr == word.length()-1) {
            return true;
        }
        if(row-1 >= 0 && board[row-1][col] == word.charAt(curr+1) && !vis[row-1][col]){
            vis[row-1][col] = true;
            boolean ans = helper(board,word,row-1,col,vis,curr+1);
            if(ans){
                return true;
            }
            vis[row-1][col] = false;
        }
        if(row+1 < board.length && board[row+1][col] == word.charAt(curr+1) && !vis[row+1][col]){
            vis[row+1][col] = true;
            boolean ans = helper(board,word,row+1,col,vis,curr+1);
            if(ans){
                return true;
            }
            vis[row+1][col] = false;
        }

        if(col-1 >= 0 && board[row][col-1] == word.charAt(curr+1) && !vis[row][col-1]){
            vis[row][col-1] = true;
            boolean ans = helper(board,word,row,col-1,vis,curr+1);
            if(ans){
                return true;
            }
            vis[row][col-1] = false;
        }

        if(col+1 < board[0].length && board[row][col+1] == word.charAt(curr+1) && !vis[row][col+1]){
            vis[row][col+1] = true;
            boolean ans = helper(board,word,row,col+1,vis,curr+1);
            if(ans){
                return true;
            }
            vis[row][col+1] = false;
        }
        return false;
    }
}