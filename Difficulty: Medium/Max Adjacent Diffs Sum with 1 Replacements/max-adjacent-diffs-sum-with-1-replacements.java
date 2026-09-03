class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;

        if (n <= 1) return 0;

        long ans = 0;

        // For each element, it can remain arr[i] or become 1.
        // DP:
        // dp0 = max sum so far when current element is unchanged
        // dp1 = max sum so far when current element is changed to 1
        long dp0 = 0;
        long dp1 = 0;

        for (int i = 1; i < n; i++) {
            long ndp0 = Math.max(
                dp0 + Math.abs((long) arr[i] - arr[i - 1]),
                dp1 + Math.abs((long) arr[i] - 1)
            );

            long ndp1 = Math.max(
                dp0 + Math.abs(1L - arr[i - 1]),
                dp1
            );

            dp0 = ndp0;
            dp1 = ndp1;
        }

        return (int) Math.max(dp0, dp1);
    }
}
