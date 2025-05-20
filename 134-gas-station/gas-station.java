class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int costsum = 0;
        int gassum = 0;
        int leftgas = 0;
        int start = 0;

        for(int i=0;i<n;i++){
            costsum+=cost[i];
            gassum+=gas[i];
            leftgas+= gas[i] - cost[i];

            if(leftgas < 0){
                leftgas = 0;
                start = i + 1;
            }
        }
        if(costsum > gassum){
            return -1;
        }
        return start;
    }
}