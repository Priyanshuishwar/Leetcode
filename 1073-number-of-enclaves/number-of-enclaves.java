class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        int one_count = 0;

        for(int i = 0; i < n;i++){
            for(int j= 0; j <m;j++){
                if(grid[i][j] == 1){
                    one_count++;
                }
            }
        }
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        for(int j = 0; j < m;j++){
            if(vis[0][j] == 0 && grid[0][j] == 1){
                dfs(0,j,vis,grid,drow,dcol);
            }
            if(vis[n - 1][j] == 0 && grid[n - 1][j] == 1){
                dfs(n - 1,j,vis,grid,drow,dcol);
            }
        }
        for(int i = 0; i < n;i++){
            if(vis[i][0] == 0 && grid[i][0] == 1){
                dfs(i,0,vis,grid,drow,dcol);
            }
            if(vis[i][m - 1] == 0 && grid[i][m - 1] == 1){
                dfs(i,m - 1,vis,grid,drow,dcol);
            }
        }
        int vis_one = 0;
        for(int i = 0; i < n;i++){
            for(int j = 0; j < m;j++){
                if(vis[i][j] == 1){
                    vis_one++;
                }
            }
        }
        return one_count - vis_one;

    }
    public static void dfs(int row,int col,int vis[][],int grid[][],int drow[],int dcol[]){
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < 4;i++){
            int nrow = drow[i] + row;
            int ncol = dcol[i] + col;
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfs(nrow,ncol,vis,grid,drow,dcol);
            }
        }
    }
}