class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int ans[] = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            if(map.get(nums[i]) > 1){
                ans[0] = nums[i];
                break;
            }
        }
        int sum = 0;
        int actual_sum = 0;
        for(int i=1;i<=n;i++){
            actual_sum += i;
        }
        int curr_sum = 0;
        for(int i=0;i<n;i++){

            curr_sum += nums[i];
        }
        curr_sum -= ans[0];
        sum = actual_sum - curr_sum;
        ans[1] = sum;
        return ans;
    }
}