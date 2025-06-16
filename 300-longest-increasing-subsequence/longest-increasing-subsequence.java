class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n + 1][n + 1];
        for(int p[] : dp){
            Arrays.fill(p,-1);
        }

        return helper(nums,0,-1,n,dp);
    }
    public static int helper(int nums[],int indx,int prevvIndx,int n,int dp[][]){
        if(indx == n){
            return 0;
        }
        if(dp[indx][prevvIndx + 1] != -1){
            return dp[indx][prevvIndx + 1];
        }
        int len = 0 + helper(nums,indx + 1,prevvIndx,n,dp);
        if(prevvIndx == -1 || nums[indx] > nums[prevvIndx]){
            len = Math.max(len,1 + helper(nums,indx + 1,indx,n,dp));
        }
        return dp[indx][prevvIndx + 1] =  len;
    }
}