class Solution {
    public static void dfs(int node,ArrayList<ArrayList<Integer>> list,boolean vis[]){
        vis[node] = true;
        for(Integer n : list.get(node)){
            if(vis[n] == false){
                dfs(n,list,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n;i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i = 0;i < n;i++){
            for(int j = 0; j < n ;j++){
                if(isConnected[i][j] == 1 && i != j){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        boolean vis[] = new boolean[n];
        int count  = 0;

        for(int i = 0; i < n ;i++){
            if(vis[i] == false){
                count++;
                dfs(i,list,vis);
            }
        }
        return count;
    }
}