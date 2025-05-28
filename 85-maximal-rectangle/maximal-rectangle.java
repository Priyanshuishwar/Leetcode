class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int largest = 0;
        int heights[] = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int val = matrix[i][j] - '0';
                if (val == 0) {
                    heights[j] = 0;
                } else {
                    heights[j] += val;
                }
            }
            int maxArea = largestRectangleArea(heights);
            if (largest < maxArea) {
                largest = maxArea;
            }
        }
        return largest;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxi = 0;
        for (int i = 0; i <= n; i++) {
            int current = (i == n) ? 0 : heights[i];
            while (!st.isEmpty() && current < heights[st.peek()]) {
                int height = heights[st.pop()];
                int width = (st.isEmpty()) ? i : i - st.peek() - 1;
                maxi = Math.max(maxi, height * width);
            }
            st.push(i);
        }
        return maxi;
    }
}