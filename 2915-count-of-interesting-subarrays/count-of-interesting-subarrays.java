class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> freq = new HashMap<>();
        freq.put(0, 1L);

        long res = 0;
        int curr = 0;

        for (int num : nums) {
            if (num % modulo == k) {
                curr++;
            }
            int modVal = curr % modulo;
            int target = (modVal - k + modulo) % modulo;

            res += freq.getOrDefault(target, 0L);

            freq.put(modVal, freq.getOrDefault(modVal, 0L) + 1);
        }

        return res;
    }
}
