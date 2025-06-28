class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int ne[] : prerequisites) {
            int u = ne[0];
            int v = ne[1];
            list.get(v).add(u);
        }
        int ans[] = new int[numCourses];
        Stack<Integer> st = new Stack<>();
        boolean recs[] = new boolean[numCourses];
        boolean vis[] = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(vis[i] == false){
                if(dfs(list,st,vis,i,recs)){
                    return new int[0];
                }
            }
        }
        int i = 0;
        while(!st.isEmpty()){
            ans[i] = st.pop();
            i++;
        }
        return ans;
    }
    public static boolean dfs(List<List<Integer>> list,Stack<Integer> st,boolean vis[],int node,boolean recs[]){
        vis[node] = true;
        recs[node] = true;
        for(int ne : list.get(node)){
            if(vis[ne] == false){
                if(dfs(list,st,vis,ne,recs)){
                    return true;
                }
            }
            else if(recs[ne]){
                    return true;
                }
        }
        st.push(node);
        recs[node] = false;
        return false;
    }
}