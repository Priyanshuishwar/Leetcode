class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] % 2 == 0){
                nums[i] = 0;
            }
            else{
                nums[i] = 1;
            }
        }
        return helper(nums,k) - helper(nums,k - 1);
    }
    public static int helper(int nums[],int k){
        if(k < 0){
            return 0;
        }
        int sum = 0;
        int n = nums.length;
        int left = 0;
        int res = 0;
        for(int right = 0;right < n; right++){
            sum += nums[right];
            while(sum > k){
                sum -= nums[left];
                left++;
            }
            res+= right - left + 1;
        }
        return res;
    }
}