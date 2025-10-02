class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = 0;
        res = numBottles;
        int count = 0;
        int empty = numBottles;
        while(empty >= numExchange){
            empty = empty - numExchange;
            numExchange++;
            res += 1;
            count++;
            if(empty < numExchange){
                empty += count;
                count = 0;
            }
        }
        return res + count;
    }
}