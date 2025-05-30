class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[] = new int[n];
        dp[0] = triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            for(int j=i;j>=0;j--){
                int curr = triangle.get(i).get(j);
                if(j == i){
                    dp[j] = curr + dp[j-1];
                }
                else if(j == 0){
                    dp[j] = curr + dp[j];
                }
                else{
                    dp[j] = Math.min(dp[j] + curr,dp[j-1] + curr);
                }
            }
        }
        // return dp[n-1];
        int mini = dp[0];
        for(int num : dp){
            mini = Math.min(mini,num);
        }
        return mini;
    }
}