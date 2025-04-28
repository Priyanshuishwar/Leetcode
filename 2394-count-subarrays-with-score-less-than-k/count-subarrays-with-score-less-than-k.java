class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int i =0;
        int j =0;
        long sum = 0;
        long count = 0;
        while(j < n){
            sum+=nums[j];
            while(sum * (j-i+1) >= k){
                sum-=nums[i];
                i++;
            }
            count+=(j-i+1);
            j++;
        }
        return count;
    }
}