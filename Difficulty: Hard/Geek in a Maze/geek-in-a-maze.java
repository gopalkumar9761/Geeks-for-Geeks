class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;

        if (mat[r][c] == '#') {
            return 0;
        }

        // Priority Queue to store state: {up_used, down_used, row, col}
        // Ordered primarily by fewer upward moves used, then fewer downward moves used.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        // Track the minimum upward moves used to reach each cell
        int[][] minUpUsed = new int[n][m];
        for (int[] row : minUpUsed) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        pq.offer(new int[]{0, 0, r, c});
        minUpUsed[r][c] = 0;

        boolean[][] visited = new boolean[n][m];
        int reachableCount = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int upUsed = curr[0];
            int downUsed = curr[1];
            int row = curr[2];
            int col = curr[3];

            if (visited[row][col]) continue;
            visited[row][col] = true;
            reachableCount++;

            for (int i = 0; i < 4; i++) {
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m) {
                    if (mat[nextRow][nextCol] == '.') {
                        int newUpUsed = upUsed + (i == 0 ? 1 : 0);
                        int newDownUsed = downUsed + (i == 1 ? 1 : 0);

                        if (newUpUsed <= u && newDownUsed <= d) {
                            if (newUpUsed < minUpUsed[nextRow][nextCol]) {
                                minUpUsed[nextRow][nextCol] = newUpUsed;
                                pq.offer(new int[]{newUpUsed, newDownUsed, nextRow, nextCol});
                            }
                        }
                    }
                }
            }
        }

        return reachableCount;
    }
}