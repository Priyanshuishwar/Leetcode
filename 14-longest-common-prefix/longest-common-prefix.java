class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        char start[] = strs[0].toCharArray();
        char end[] = strs[n - 1].toCharArray();

        for(int i = 0; i < start.length; i++){
            if(start[i] != end[i]){
                break;
            }
            sb.append(start[i]);
        }
        return sb.toString();
    }
}