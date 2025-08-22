class Solution {
    public void solveSudoku(char[][] board) {
         int n = board.length;
         int m = board[0].length;
         solve(board,n,m); 
    }
    public static boolean solve(char[][] board,int n,int m){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board,c,i,j)){
                            board[i][j] = c;

                            if(solve(board,n,m) == true){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValid(char[][] board,char c,int row,int col){
        for(int i = 0; i < 9; i++){
            if(board[i][col] == c){
                return false;
            }
            if(board[row][i] == c){
                return false;
            }
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c){
                return false;
            }
        }
        return true;
    }
}