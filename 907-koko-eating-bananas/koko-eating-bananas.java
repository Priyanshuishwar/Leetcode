class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int ele : piles) {
            max = Math.max(max, ele);
        }
        int low = 1;
        int high = max;
        int res = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canEat(piles, h, mid)) {
                high = mid - 1;
                res = mid;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public boolean canEat(int piles[], int h, int speed) {
        long hours = 0;  
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;  
        }
        return hours <= h;
    }
}
