class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);
        while(!dq.isEmpty()){
            int i = dq.poll();
            if(arr[i] == 0){
                return true;
            }
            int x = arr[i];
            arr[i] = -1;
            for(int j : List.of(i + x, i - x)){
                if(j >= 0 && j < arr.length && arr[j] >= 0){
                    dq.offer(j);
                }
            }
        }
        return false;
    }
}