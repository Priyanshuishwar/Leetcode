class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int res[] = new int[n];
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> set3 = new HashSet<>();
        int count = 0;

        for(int i=0;i<n;i++){
            set1.add(A[i]);
            set2.add(B[i]);
            if(set2.contains(A[i]) && !set3.contains(A[i])){
                count++;
                set3.add(A[i]);
            }
            if(set1.contains(B[i]) && !set3.contains(B[i])){
                count++;
                set3.add(B[i]);
            }
            res[i] = count;
        }
        return res;
    }
}