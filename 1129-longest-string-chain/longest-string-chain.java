class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words,(a,b) -> a.length() - b.length());
        int dp[] = new int[n];
        Arrays.fill(dp,1);

        for(int i = 0; i < n;i++){
            for(int j = 0; j < i; j++){
                if(check(words[i],words[j]) && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                }
            }
        }
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n;i++){
            if(dp[i] > maxi){
                maxi = dp[i];
            }
        }
        return maxi;
    }
    public static boolean check(String s1,String s2){
        if(s1.length() != s2.length() + 1){
            return false;
        }
        int i = 0;
        int j = 0;
        while(i < s1.length()){
            if(j < s2.length() && s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        if(i == s1.length() && j == s2.length()){
            return true;
        }
        return false;
    }
}