class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]> res=new ArrayList<>();
        res.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int s=intervals[i][0];
            int e=intervals[i][1];
            int last[]=res.get(res.size()-1);
            if(last[1]<s){
                res.add(intervals[i]);
            }
            else{
                last[1]=Math.max(last[1],e);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}