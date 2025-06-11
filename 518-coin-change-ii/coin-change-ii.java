class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n +1][amount +1];
        for(int p[] : dp){
            Arrays.fill(p,-1);
        }

        return helper(coins,n,amount,0,dp);
    }
    public static int helper(int coin[],int n,int amount,int i,int dp[][]){
        if(amount == 0){
            return 1;
        }
        if(i == n){
            return 0;
        }
        if(coin[i] > amount){
            return dp[i][amount] = helper(coin,n,amount,i+1,dp);
        }
        if(dp[i][amount] != -1){
            return dp[i][amount];
        }
        int take = helper(coin,n,amount - coin[i],i,dp);
        int skip = helper(coin,n,amount,i + 1,dp);

        dp[i][amount] = take + skip;
        return dp[i][amount];
    }
}