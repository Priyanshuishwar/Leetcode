class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> list = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        //     list.add(new ArrayList<>());
        // }
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int node : graph[i]) {
                temp.add(node);
            }
            list.add(temp);
        }
        int vis[] = new int[n];
        int recs[] = new int[n];
        int check[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(list, vis, recs, check, i);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (check[i] == 1) {
                res.add(i);
            }
        }
        return res;
    }

    public static boolean dfs(List<List<Integer>> list, int vis[], int recs[], int check[], int node) {
        vis[node] = 1;
        recs[node] = 1;
        check[node] = 0;
        for (int nei : list.get(node)) {
            if (vis[nei] == 0) {
                if (dfs(list, vis, recs, check, nei) == true) {
                    return true;
                }
            } else if (recs[nei] == 1) {
                return true;
            }
        }
        check[node] = 1;
        recs[node] = 0;
        return false;
    }
}