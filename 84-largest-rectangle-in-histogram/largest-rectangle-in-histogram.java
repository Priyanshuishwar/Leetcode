class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int val = 0;
            if (i == n) {
                val = 0;
            } else {
                val = heights[i];
            }
            while (!st.isEmpty() && val < heights[st.peek()]) {
                int height = heights[st.pop()];
                int width = 0;
                if(st.isEmpty()){
                    width = i;
                }
                else{
                    width = i - st.peek() - 1;
                }
                ans = Math.max(ans, width * height);
            }
            st.push(i);
        }
        return ans;
    }
}