class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String s1 = sb.toString();
        int dp[][] = new int[n + 1][n + 1];
        for(int p[] : dp){
            Arrays.fill(p,-1);
        }

        int ans = helper(s,s1,n,0,0,dp);
        return n - ans;

    }
    public static int helper(String s,String s1,int n,int i,int j,int dp[][]){
        if(i == n || j == n){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s1.charAt(j)){
            return dp[i][j] = 1 + helper(s,s1,n,i + 1,j + 1,dp);
        }
        else{
            return dp[i][j] = Math.max(helper(s,s1,n,i + 1,j,dp),helper(s,s1,n,i,j + 1,dp));
        }
    }
}