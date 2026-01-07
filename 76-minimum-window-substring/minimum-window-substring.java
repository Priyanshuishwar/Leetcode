class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int min_len = Integer.MAX_VALUE;
        int count = 0;
        int si = -1;

        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count++;
                }
            }

            while (count == m) {
                if (r - left + 1 < min_len) {
                    min_len = r - left + 1;
                    si = left;
                }

                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if (map.get(s.charAt(left)) > 0) {
                        count--;
                    }
                }

                left++;
            }
        }
        return min_len == Integer.MAX_VALUE ? "" : s.substring(si,si + min_len);
    }
}