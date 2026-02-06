class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        while(i < n){
            if(nums[i] != 0){
                swap(nums,i,j);
                i++;
                j++;
            }
            else{
                i++;
            }
        }
    }
    public static void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}