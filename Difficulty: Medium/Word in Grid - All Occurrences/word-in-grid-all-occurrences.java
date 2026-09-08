import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;

        // 8 directions: Up, Down, Left, Right, 4 Diagonals
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Traverse through each cell in lexicographical order (row major order)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // Check if the current cell matches the start character
                if (mat[i][j] == word.charAt(0)) {

                    // Search in all 8 directions
                    for (int dir = 0; dir < 8; dir++) {
                        if (checkDirection(mat, word, i, j, dx[dir], dy[dir], n, m)) {
                            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
                            ArrayList<Integer> pos = new ArrayList<>();
                            pos.add(i);
                            pos.add(j);
                            result.add(pos);

                            // Once found from (i, j), break to ensure unique starting coordinates
                            break; 
                        }
                    }
                }
            }
        }

        return result;
    }

    private boolean checkDirection(char[][] mat, String word, int r, int c, int dr, int dc, int n, int m) {
        int wordLen = word.length();

        for (int k = 0; k < wordLen; k++) {
            int nr = r + k * dr;
            int nc = c + k * dc;

            // Out of bounds or character mismatch check
            if (nr < 0 || nr >= n || nc < 0 || nc >= m || mat[nr][nc] != word.charAt(k)) {
                return false;
            }
        }

        return true;
    }
}