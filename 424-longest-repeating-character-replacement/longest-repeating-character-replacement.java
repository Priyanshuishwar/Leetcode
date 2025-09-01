class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxlen = 0;
        int maxCount = 0;
        int freq[] = new int[26];
        for(right = 0;right < n; right++){
            freq[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount,freq[s.charAt(right) - 'A']);

            while((right - left + 1) - maxCount > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxlen = Math.max(maxlen,right - left + 1);
        }
        return maxlen;
    }
}