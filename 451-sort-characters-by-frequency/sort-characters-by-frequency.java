class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq =
            new PriorityQueue<>((a, b) -> {
                if (!a.getValue().equals(b.getValue())) {
                    return b.getValue() - a.getValue();
                } else {
                    return a.getKey() - b.getKey();
                }
            });
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> entry = pq.poll();
            char ch = entry.getKey();
            int count = entry.getValue();
            for(int i = 0; i < count; i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
