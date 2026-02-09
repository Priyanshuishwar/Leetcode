class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> li = new ArrayList<>();

        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        for(char ch : p.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        int right = 0;
        int left = 0;
        while(right < n){
            window.put(s.charAt(right),window.getOrDefault(s.charAt(right),0) + 1);
            right++;

            if(right - left == m){
                if(window.equals(map)){
                    li.add(left);
                }
                window.put(s.charAt(left),window.get(s.charAt(left)) - 1);
                if(window.get(s.charAt(left)) == 0){
                    window.remove(s.charAt(left));
                }
                left++;
            }
        }
        return li;
    }
}