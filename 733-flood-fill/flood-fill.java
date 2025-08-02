class Pair {
    int row;
    int col;

    Pair(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        Queue<Pair> q = new LinkedList<>();
        int start = image[sr][sc];
        image[sr][sc] = color;
        if (start == color) {
            return image;
        }
        q.add(new Pair(sr, sc));
        int rd[] = { -1, 0, 1, 0 };
        int cd[] = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;

            q.remove();
            for (int i = 0; i < 4; i++) {
                int nrd = rd[i] + r;
                int ncd = cd[i] + c;
                if (nrd >= 0 && nrd < n && ncd >= 0 && ncd < m && image[nrd][ncd] == start) {
                    q.add(new Pair(nrd, ncd));
                    image[nrd][ncd] = color;
                }
            }
        }
        return image;
    }
}