class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int ls = 0;
        int rs = 0;
        int indx = n - 1;
         int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        while(left <= right){
            ls = nums[left] * nums[left];
            rs = nums[right] * nums[right];

            if(ls < rs){
                result[indx] = rs;
                right--;
                indx--;
            }
            else{
                result[indx] = ls;
                left++;
                indx--;
            }
        }
        return result;
    }
}