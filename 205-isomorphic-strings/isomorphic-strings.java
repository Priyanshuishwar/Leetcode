class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        HashMap<Character,Integer> m1 = new HashMap<>();
        HashMap<Character,Integer> m2 = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(!m1.containsKey(s.charAt(i))){
                m1.put(s.charAt(i),i);
            }
            if(!m2.containsKey(t.charAt(i))){
                m2.put(t.charAt(i),i);
            }
            
            if(!m1.get(s.charAt(i)).equals(m2.get(t.charAt(i)))){
                return false;
            }
        }
        return true;
    }
}