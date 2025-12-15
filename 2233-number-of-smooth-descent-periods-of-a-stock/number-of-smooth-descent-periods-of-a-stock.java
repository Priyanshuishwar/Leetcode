class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long dp[] = new long[n];
        Arrays.fill(dp,1);

        for(int i = 1; i < n; i++){
            if(prices[i] < prices[i - 1] && (prices[i - 1] - prices[i] == 1)){
                dp[i] = dp[i - 1] +dp[i];
            }
        }
        long ans = 0;
        for(int i = 0; i < n; i++){
            ans += dp[i];
        }
        return ans;
    }
}