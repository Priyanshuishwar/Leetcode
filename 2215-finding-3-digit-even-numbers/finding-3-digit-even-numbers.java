class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        if(n < 3){
            return new int[]{};
        }
        int freq[] = new int[10];
        for(int digit : digits){
            freq[digit]++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<=9;i++){
            if(freq[i] == 0){
                continue;
            }
            freq[i]--;
            for(int j=0;j<=9;j++){
                if(freq[j] == 0){
                    continue;
                }
                freq[j]--;
            for(int k=0;k<=8;k+=2){
                if(freq[k] == 0){
                    continue;
                }
                res.add(i*100+j*10+k);
            }
            freq[j]++;
            }
            freq[i]++;
        }
        int n1 = res.size();
        int ans[] = new int [n1];
        for(int i=0;i<n1;i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}