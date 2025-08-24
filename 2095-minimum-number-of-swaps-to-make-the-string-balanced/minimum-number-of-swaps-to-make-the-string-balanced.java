class Solution {
    public int minSwaps(String s) {
        int n = s.length();
        int open = 0;
        int unbalanced = 0;
        for(char ch : s.toCharArray()){
            if(ch == '['){
                open++;
            }
            else{
                if(open > 0){
                    open--;
                }
                else{
                    unbalanced++;
                }
            }
        }
        return (unbalanced + 1) / 2;
    }
}