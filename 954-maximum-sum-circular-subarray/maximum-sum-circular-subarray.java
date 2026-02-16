class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int sum1 = 0;
        int sum2 = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int totalSum = 0;

        for(int i = 0; i < n; i++){
            totalSum += nums[i];
            sum1 = Math.max(nums[i],sum1 + nums[i]);
            maxSum = Math.max(maxSum,sum1);

            sum2 = Math.min(nums[i],sum2 + nums[i]);
            minSum = Math.min(minSum,sum2);
        }
        if(maxSum < 0){
            return maxSum;
        }
        return Math.max(maxSum, totalSum - minSum);
    }
}