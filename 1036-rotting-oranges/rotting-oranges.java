class Pair{
    int row;
    int col;
    int time;
    Pair(int r,int c,int tm){
        this.row = r;
        this.col = c;
        this.time = tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshCount = 0;
        int vis[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n;i++){
            for(int j = 0; j < m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        int time  = 0;
        int count = 0;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int to = q.peek().time;
            q.remove();
            time = Math.max(time,to);
            for(int i = 0; i < 4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    q.add(new Pair(nrow,ncol,to + 1));
                    vis[nrow][ncol] = 2;
                    count++;
                }
            }
        }
        if(freshCount != count){
            return -1;
        }
        return time;
    }
}