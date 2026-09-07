class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[][][] memo = new int[n][n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        int maxSelected = solve(0, n, n, arr, memo);
        return n - maxSelected;
    }

    private int solve(int i, int incIdx, int decIdx, int[] arr, int[][][] memo) {
        if (i == arr.length) {
            return 0;
        }

        if (memo[i][incIdx][decIdx] != -1) {
            return memo[i][incIdx][decIdx];
        }

        int ans = solve(i + 1, incIdx, decIdx, arr, memo);

        int incVal = (incIdx == arr.length) ? Integer.MIN_VALUE : arr[incIdx];
        int decVal = (decIdx == arr.length) ? Integer.MAX_VALUE : arr[decIdx];

        if (arr[i] > incVal) {
            ans = Math.max(ans, 1 + solve(i + 1, i, decIdx, arr, memo));
        }

        if (arr[i] < decVal) {
            ans = Math.max(ans, 1 + solve(i + 1, incIdx, i, arr, memo));
        }

        return memo[i][incIdx][decIdx] = ans;
    }
}