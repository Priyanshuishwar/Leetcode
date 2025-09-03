class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int opening = 0;
        int maxi = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(' ){
                opening++;
                maxi = Math.max(maxi,opening);
            }
            else if(s.charAt(i) == ')'){
                opening--;
            }
        }
        return maxi;
    }
}