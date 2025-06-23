import java.util.*;

class Solution {
    public static boolean check(int node, List<List<Integer>> list, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 0;

        while (!q.isEmpty()) {
            int val = q.poll();
            for (Integer it : list.get(val)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[val];
                    q.add(it);
                } else if (color[it] == color[val]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> neighbors = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                neighbors.add(graph[i][j]);
            }
            list.add(neighbors);
        }

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!check(i, list, color)) {
                    return false;
                }
            }
        }

        return true;
    }
}
