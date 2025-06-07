class Solution {
    public static List<Integer> getAll(int nums[],int start,int end){
        List<Integer> res = new ArrayList<>();
        int len = end - start + 1;
        int total = 1 << len;

        for(int i=0;i<total;i++){
            int sum = 0;
            for(int j=0;j<len;j++){
                if((i & (1 << j)) != 0){
                    sum += nums[start + j];
                }
            }
            res.add(sum);
        }
        return res;
    }
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        if(n == 1){
            return Math.min(Math.abs(goal),Math.abs(nums[0] - goal));
        }
        List<Integer> firstHalf = getAll(nums,0,n/2-1);
        List<Integer> secHalf = getAll(nums,n/2,n-1);

        Collections.sort(secHalf);
        int res = Integer.MAX_VALUE;

        for(int sum1 : firstHalf){
            int rem = goal - sum1;
            int indx = Collections.binarySearch(secHalf,rem);

            if(indx >= 0){
                return 0;
            }
            indx = -indx -1;
            if(indx < secHalf.size()){
                res = Math.min(res,Math.abs(goal - (sum1 + secHalf.get(indx))));
            }
            if(indx > 0){
               res = Math.min(res, Math.abs(goal - (sum1 + secHalf.get(indx - 1))));
            }
        }
        return res;

    }
}