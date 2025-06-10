class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];

        for (int i = 0; i < n; i++) {
            int var = Math.abs(nums[i]);
            if (nums[var - 1] > 0) {
                nums[var - 1] *= -1;
            } else {
                ans[0] = var; 
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[1] = i + 1;
            }
        }

        return ans;
    }
}
