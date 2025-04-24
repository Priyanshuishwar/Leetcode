class Solution {
    public String removeKdigits(String num, int k) {
        char ch[] = num.toCharArray();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<ch.length;i++){
            while(!st.isEmpty() && k > 0 && st.peek() > ch[i]){
                st.pop();
                k--;
            }
            st.push(ch[i]);

        }
        while(k > 0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : st){
            sb.append(c);
        }
        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}