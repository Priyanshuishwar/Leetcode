class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // First step change - [][] to list
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int edge[] : prerequisites){
            int u = edge[0];
            int v = edge[1];
            list.get(v).add(u);
        }
        // Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[numCourses];
        boolean recs[] = new boolean[numCourses];

        for(int i = 0; i < numCourses;i++){
            if(vis[i] == false){
                if(dfs(list,vis,recs,i)){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean dfs(List<List<Integer>> list,boolean vis[],boolean recs[],int node){
        vis[node] = true;
        recs[node] = true;
        for(int nei : list.get(node)){
            if(vis[nei] == false){
                if(dfs(list,vis,recs,nei)){
                    return true;
                }
            }
            else if(recs[nei]){
                return true;
            }
        }
        recs[node] = false;
        // st.add(node);
        return false;
    }
}