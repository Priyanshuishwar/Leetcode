class Solution {
    public static class pair{
        int height;
        int row;
        int col;
        pair(int h,int row,int col){
            this.height = h;
            this.row = row;
            this.col = col;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;
        PriorityQueue<pair> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.height));
        boolean vis[][] = new boolean[n][m];
        int water = 0;


        for(int i = 0; i < n; i++){
            pq.offer(new pair(heightMap[i][0],i,0));
            vis[i][0] = true;

            pq.offer(new pair(heightMap[i][m - 1],i,m-1));
            vis[i][m - 1] = true;
        }

        for(int j = 0; j < m; j++){
            pq.offer(new pair(heightMap[0][j],0,j));
            vis[0][j] = true;

            pq.offer(new pair(heightMap[n - 1][j],n - 1,j));
            vis[n - 1][j] = true;
        }
        int dirr[] = {1,0,-1,0};
        int dirc[] = {0,1,0,-1};

        while(!pq.isEmpty()){
            pair curr = pq.poll();
            int minH = curr.height;

            for(int i = 0; i < 4; i++){
                int nr = dirr[i] + curr.row;
                int nc = dirc[i] + curr.col;

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    water += Math.max(0,minH - heightMap[nr][nc]);
                    pq.offer(new pair(Math.max(minH,heightMap[nr][nc]),nr,nc));
                }
            }
        }
        return water;
    }
}