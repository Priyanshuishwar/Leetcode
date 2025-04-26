class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i =0;
        int j = 0;
        int sum = 0;
        int min_len = Integer.MAX_VALUE;
        while(j < n){
            sum+=nums[j];
            while(sum >= target){
                min_len = Math.min(j-i+1,min_len);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return min_len == Integer.MAX_VALUE ? 0 : min_len;
    }
}