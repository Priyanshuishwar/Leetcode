class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        if(sum %2 != 0){
            return false;
        }
        int target = sum / 2;
        int dp[][] = new int[n+1][target+1];
        for(int p[]:dp){
            Arrays.fill(p,-1);
        }
        return helper(nums,target,n,dp);
    }
    public static boolean helper(int nums[],int target,int n,int dp[][]){
        if(n == 0){
            return false;
        }
        if(target == 0){
            return true;
        }
        if(dp[n][target]!= -1){
            return dp[n][target] == 1;
        }
        if(nums[n-1] > target){
            dp[n][target] = helper(nums,target,n-1,dp) ? 1:0;
        }
        else{
             dp[n][target] = (helper(nums,target,n-1,dp) || helper(nums,target-nums[n-1],n-1,dp))?1:0;
        }
        return dp[n][target] ==1;
    }
}