class Solution {
    public int minFallingPathSum(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] a: dp)Arrays.fill(a,-100000);
        for(int i =0;i<grid[0].length;i++){
            int a = help(grid, 0,i, dp);
            ans = Math.min(a, ans);
        }
        return ans;

    }
    public static int help(int[][] grid, int i , int j, int[][] dp){
        if(i<0 || j<0 || i>= grid.length || j>= grid[0].length)return Integer.MAX_VALUE;
        if(i == grid.length-1)return grid[i][j];
        if(dp[i][j] != -100000)return dp[i][j];

        return dp[i][j] = grid[i][j]+Math.min(help(grid, i+1,j-1,dp),Math.min(help(grid, i+1,j, dp),help(grid, i+1,j+1, dp)));
    }
}