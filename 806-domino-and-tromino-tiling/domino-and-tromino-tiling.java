class Solution {
    private static final int mod = 1_000_000_007;
    public int numTilings(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;
        int[] res = new int[n+1];
        res[0] = 1; res[1] = 1; res[2] = 2; res[3] = 5;
        for (int i = 4; i <= n; i++) {
            res[i] = (int)((2L * res[i-1] + res[i-3]) % mod);
        }
        return res[n];
    }
}