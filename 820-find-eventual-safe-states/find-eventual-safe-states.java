class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int node : graph[i]) {
                temp.add(node);
            }
            list.add(temp);
        }
        List<List<Integer>> revlist = new ArrayList<>();
        for(int i = 0;i < n;i++){
            revlist.add(new ArrayList<>());
        }
        int indegree[] = new int[n];
        for(int i = 0; i < n; i++){
            // i -> nei
            // nei -> i

            for(int nei : list.get(i)){
                revlist.get(nei).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safe = new ArrayList<>();
        for(int i = 0; i < n;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            safe.add(node);
            for(int neighbour : revlist.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        Collections.sort(safe);
        return safe;
    }
}    