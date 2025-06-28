class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // int n = prerequisites.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int nei[] : prerequisites){
            int u = nei[0];
            int v = nei[1];
            list.get(u).add(v);
        }
        int indegree[] = new int[numCourses];
        for(int i = 0; i < numCourses;i++){
            for(int nei : list.get(i)){
                indegree[nei]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            topo.add(node);
            q.remove();

            for(int ne : list.get(node)){
                indegree[ne]--;
                if(indegree[ne] == 0){
                    q.add(ne);
                }
            }
        }
        if(topo.size() == numCourses){
            return true;
        }
        return false;
    }
}