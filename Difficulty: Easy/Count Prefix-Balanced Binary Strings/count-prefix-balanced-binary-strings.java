class Solution {
    public int prefixStrings(int n) {
        long MOD = 1000000007;
        long[] dp = new long[n + 1];

        dp[0] = 1;
        if (n >= 1) {
            dp[1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            long res = 0;
            for (int j = 0; j < i; j++) {
                long product = (dp[j] * dp[i - 1 - j]) % MOD;
                res = (res + product) % MOD;
            }
            dp[i] = res;
        }

        return (int) dp[n];
    }
}