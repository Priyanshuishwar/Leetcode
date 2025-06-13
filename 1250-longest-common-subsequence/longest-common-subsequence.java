class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n + 1][m + 1];
        for(int p[] : dp){
            Arrays.fill(p,-1);
        } 


        return helper(text1,text2,n,m,0,0,dp);
    }
    public static int helper(String text1,String text2,int n,int m,int i,int j,int dp[][]){
        if(i == n || j == m){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)){
            dp[i][j] =  1 + helper(text1,text2,n,m,i + 1,j + 1,dp);
            return dp[i][j];
        }
        else{
            dp[i][j] =  Math.max(helper(text1,text2,n,m,i + 1,j,dp), helper(text1,text2,n,m,i,j + 1,dp));
            return dp[i][j];
        }
        // return dp[n][m];
    }
}