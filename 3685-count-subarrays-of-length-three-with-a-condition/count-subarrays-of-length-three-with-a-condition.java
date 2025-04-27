class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return 0;
        }
        int res = 0;
        for(int i=1;i<n-1;i++){
            if(nums[i] % 2 == 0 && nums[i]/2 == nums[i-1] + nums[i+1]){
                res++;
            }
        }
        return res;
    }
}