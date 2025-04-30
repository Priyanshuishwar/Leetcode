class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int i=0;i<n;i++){
            int count = 0;
            int p = nums[i];
            while(p > 0){
                int rem = p % 10;
                count++;
                p=p/10;
            }
            if(count % 2 == 0){
                res++;
            }
        }
        return res;
    }
}