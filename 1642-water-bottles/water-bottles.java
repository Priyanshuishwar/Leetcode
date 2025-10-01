class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        ans += numBottles;
        int empty = numBottles;

        while(numExchange <= empty){
            int exchange = empty / numExchange;
            ans += exchange;
            empty = empty % numExchange + exchange;
        }
        return ans;
    }
}