class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if( n != m){
            return false;
        }
       int freq[] = new int[26];
       for(int i = 0; i < n; i++){
        freq[s.charAt(i) - 'a']++;
       }
       for(int i = 0; i < m; i++){
        if(freq[t.charAt(i) - 'a'] == 0){
            return false;
        }
        else{
            freq[t.charAt(i) - 'a'] -=  1;
        }
       }
       return true;
    }
}