class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int p[] : dp){
            Arrays.fill(p,-1);
        }

        return helper(s, t, n, m, dp);
    }

    public static int helper(String s, String t, int i, int j, int[][] dp) {
        if (j == 0) return 1;
        if (i == 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            dp[i][j] = helper(s, t, i - 1, j - 1, dp) + helper(s, t, i - 1, j, dp);
        } else {
            dp[i][j] = helper(s, t, i - 1, j, dp);
        }

        return dp[i][j];
    }
}
