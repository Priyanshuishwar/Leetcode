class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m - 1;
        while(low <= high){
            int mid = low + (high - low)/ 2;
            int maxEleindx = helper(mat,n,m,mid);
            int left = 0;
            if(mid - 1 >= 0){
                left = mat[maxEleindx][mid - 1];
            }
            else{
                left = -1;
            }
            int right = 0;
            if(mid + 1 < m){
                right = mat[maxEleindx][mid + 1];
            }
            else{
                right = -1;
            }
            if(mat[maxEleindx][mid] >left && mat[maxEleindx][mid] > right){
                return new int[]{maxEleindx,mid};
            }
            else if(mat[maxEleindx][mid] < left){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
    public static int helper(int mat[][],int n,int m,int col){
        int indx = -1;
        int maxVal = -1;
        for(int i = 0; i < n ;i++){
            if(mat[i][col] > maxVal){
                maxVal = mat[i][col];
                indx = i;
            }
        }
        return indx;
    }
}