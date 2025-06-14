class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n + 1][m + 1];

        for(int p[] : dp){
            Arrays.fill(p,-1);
        }

        return helper(word1,word2,n-1,m-1,dp);
    }
    public static int helper(String s1,String s2,int i,int j,int dp[][]){
        if(i < 0){
            return j + 1;
        }
        if(j < 0){
            return i + 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return helper(s1,s2,i-1,j-1,dp);
        }
        else{
            int insert = 1 + helper(s1,s2,i,j-1,dp);
            int delete = 1 + helper(s1,s2,i-1,j,dp);
            int replace = 1 + helper(s1,s2,i-1,j-1,dp);

            return dp[i][j] = Math.min(insert,Math.min(delete,replace));
        }
    }
}