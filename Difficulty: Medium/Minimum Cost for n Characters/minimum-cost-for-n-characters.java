class Solution {
    public int minCost(int n, int i, int d, int c) {
        long[] dp = new long[n + 1];
        dp[0] = 0;

        for (int x = 1; x <= n; x++) {
            // Option 1: Ek character insert karna
            dp[x] = dp[x - 1] + i;

            // Option 2: Copy-paste (Double) operation se aana
            if (x % 2 == 0) {
                // Agar x even hai: x/2 se double karo
                dp[x] = Math.min(dp[x], dp[x / 2] + c);
            } else {
                // Agar x odd hai: (x+1)/2 se double karke 1 delete karo
                dp[x] = Math.min(dp[x], dp[(x + 1) / 2] + c + d);
            }
        }

        return (int) dp[n];
    }
}