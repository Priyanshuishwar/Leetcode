class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long)m * k > bloomDay.length) return -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        int low = min;
        int high = max;
        int answer = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(bloomDay, mid, m, k)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    public static boolean possible(int[] arr, int day, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                    if (bouquets == m) return true;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
