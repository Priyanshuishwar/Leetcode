class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int p[] : dp){
            Arrays.fill(p,-1);
        }
        return helper(m-1,n-1,dp);
    }
    public static int helper(int m,int n,int dp[][]){
        if(m < 0 || n < 0){
            return 0;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        if(m == 0 || n == 0){
            dp[m][n] = 1;
        }
        else{
            dp[m][n] = helper(m-1,n,dp) + helper(m,n-1,dp);
        }
        return dp[m][n];
    }
}