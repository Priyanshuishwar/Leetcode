class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int count[] = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);

        for(int i = 0; i < n;i++){
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j] && 1 + dp[j] > dp[i]){
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }
                else if(nums[i] > nums[j] && 1 + dp[j] == dp[i]){
                    count[i] += count[j];
                }
            }
        }
        int maxi = 0;
        for(int i = 0; i < n;i++){
            if(dp[i] > maxi){
                maxi = dp[i];
            }
        }
        int ans = 0;
        for(int i = 0; i < n;i++){
            if(dp[i] == maxi){
                ans += count[i];
            }
        }
        return ans;
    }
}