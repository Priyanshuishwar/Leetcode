class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i == 0 || groups[i] != groups[i-1]){
                res.add(words[i]);
            }
        }
        return res;
    }
}