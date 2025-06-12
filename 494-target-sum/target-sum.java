class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int dp[][] = new int[nums.length][1001];
        for(int []d : dp){
            Arrays.fill(d, -1);
        }
        return tar(nums , 0 , 0, target , dp);
    }
    int tar(int nums[] , int target , int index , int sum, int dp[][]){
        if(index>= nums.length){
            if(target == sum){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(target >0 && dp[index][target] != -1){
            return dp[index][target];
        }
        int add = tar(nums , target + nums[index] , index+1 , sum , dp);
        int sub = tar(nums , target - nums[index] , index+1 , sum , dp);
        if(target> 0){
            dp[index][target] = add+ sub;
        }
        return add+sub;
    }
}