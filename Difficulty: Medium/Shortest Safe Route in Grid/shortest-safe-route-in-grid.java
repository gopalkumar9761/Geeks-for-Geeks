class Solution {
    public int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] unsafe = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    unsafe[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                            unsafe[ni][nj] = true;
                        }
                    }
                }
            }
        }

        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (!unsafe[i][0]) {
                queue.add(new int[]{i, 0, 1});
                visited[i][0] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];

            if (c == m - 1) {
                return dist;
            }

            for (int k = 0; k < 4; k++) {
                int nr = r + dx[k];
                int nc = c + dy[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !unsafe[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }
}