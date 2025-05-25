class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,res,ans,n,0);
        return ans;
    }
    public static void helper(int nums[],List<Integer> res,List<List<Integer>> ans,int n,int indx){
        if(indx == n){
            ans.add(new ArrayList<>(res));
            return ;
        }
        helper(nums,res,ans,n,indx+1);
        res.add(nums[indx]);
        helper(nums,res,ans,n,indx+1);
        res.remove(res.size() -1);
    }
}