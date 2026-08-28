class Solution {
    public int minCost(int[][] mat) {
        int n = mat.length;
        if (n == 0) return 0;

        // Variables to store the minimum cost of the previous row for each choice (0, 1, and 2)
        int prevChoice0 = mat[0][0];
        int prevChoice1 = mat[0][1];
        int prevChoice2 = mat[0][2];

        // Iterate through each row starting from the second row
        for (int i = 1; i < n; i++) {
            // Calculate current row's minimum costs based on previous row's choices
            int currChoice0 = mat[i][0] + Math.min(prevChoice1, prevChoice2);
            int currChoice1 = mat[i][1] + Math.min(prevChoice0, prevChoice2);
            int currChoice2 = mat[i][2] + Math.min(prevChoice0, prevChoice1);

            // Update previous choices for the next iteration
            prevChoice0 = currChoice0;
            prevChoice1 = currChoice1;
            prevChoice2 = currChoice2;
        }

        // The answer is the minimum of the three choices at the last row
        return Math.min(prevChoice0, Math.min(prevChoice1, prevChoice2));
    }
}