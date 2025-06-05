class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int m = intervals[0].length;
        Arrays.sort(intervals,(a,b)->a[1] - b[1]);
        int value = intervals[0][1];
        int count = 1;
        int previous = 0;

        for(int i=1;i<n;i++){
            int over = intervals[i][0];
            if(value <= over){
                count++;
                value = intervals[i][1];

            }
            
        }   
        return n - count;
    }
}