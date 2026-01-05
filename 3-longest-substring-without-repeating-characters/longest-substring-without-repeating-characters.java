class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int len = 0;
        int left = 0;

        for(int i = 0; i < n; i++){
            while(map.containsKey(s.charAt(i))){
                map.put(s.charAt(left),map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
                map.put(s.charAt(i),1);
                len = Math.max(len,i - left + 1);
        }
        return len;
    }
}