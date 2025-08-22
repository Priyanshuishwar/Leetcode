class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        helper(num, target, 0, list, "", 0, 0);
        return list;
    }

    public static void helper(String num, int target, int indx, List<String> list, String path, long sum, long tail) {
        if (indx == num.length()) {
            if (sum == target) {
                list.add(path);
            }
            return;
        }

        for (int i = indx; i < num.length(); i++) {
            
            if (i != indx && num.charAt(indx) == '0') {
                break;
            }

            String currStr = num.substring(indx, i + 1);
            long currNum = Long.parseLong(currStr);

            if (indx == 0) {
                helper(num, target, i + 1, list, currStr, currNum, currNum);
            } else {
                helper(num, target, i + 1, list, path + "+" + currStr, sum + currNum, currNum);
                
                helper(num, target, i + 1, list, path + "-" + currStr, sum - currNum, -currNum);

                helper(num, target, i + 1, list, path + "*" + currStr, sum - tail + tail * currNum, tail * currNum);
            }
        }
    }
}
