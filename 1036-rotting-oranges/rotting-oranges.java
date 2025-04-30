class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh_count = 0;
        Queue<int []> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    fresh_count++;
                }
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }

        if(fresh_count == 0){
            return 0;
        }

        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean rotted = false; 

            for(int i = 0; i < size; i++){
                int[] rotten = q.poll();
                int r = rotten[0];
                int c = rotten[1];
                int[][] neighbours = {{r-1,c}, {r,c+1}, {r+1,c}, {r,c-1}};

                for(int[] nei : neighbours){
                    int nr = nei[0];
                    int nc = nei[1];

                    if(nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] != 1){
                        continue;
                    }

                    q.offer(new int[]{nr, nc});
                    grid[nr][nc] = 2;
                    fresh_count--;
                    rotted = true;
                }
            }

            if(rotted){
                time++;
            }
        }

        return (fresh_count == 0) ? time : -1;
    }
}
