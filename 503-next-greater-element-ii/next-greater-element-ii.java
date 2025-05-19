class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();

        for(int i =0;i<2*n;i++){
            int indx = i % n;
            while(!st.isEmpty() && nums[indx] > nums[st.peek()]){
                int index = st.pop();
                res[index] = nums[indx];
            }
            st.push(indx);

        }
        return res;
    }
}