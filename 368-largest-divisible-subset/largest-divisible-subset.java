class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        for(int i = 0; i < n;i++){
            hash[i] = i;
        }
        Arrays.fill(dp,1);

        for(int i = 0; i < n;i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
        }
        int ans = -1;
        int indx = -1;

        for(int i = 0 ;i < n;i++){
            if(dp[i] > ans){
                ans = dp[i];
                indx = i;
            }
        }
        list.add(nums[indx]);
        while(hash[indx] != indx){
            indx = hash[indx];
            list.add(nums[indx]);
        }
        return list;
    }
}