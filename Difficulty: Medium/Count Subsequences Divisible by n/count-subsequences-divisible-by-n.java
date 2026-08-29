class Solution {
    public int countSubsequences(String s, int n) {
        int MOD = 1000000007;
        int len = s.length();

        // dp[j] stores the count of subsequences having a remainder 'j' modulo n
        long[] dp = new long[n];

        for (int i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';
            long[] nextDp = new long[n];

            // Copy previous counts
            for (int j = 0; j < n; j++) {
                nextDp[j] = dp[j];
            }

            // A single digit subsequence starting with this character
            nextDp[digit % n] = (nextDp[digit % n] + 1) % MOD;

            // Extend all existing subsequences with the current digit
            for (int j = 0; j < n; j++) {
                if (dp[j] > 0) {
                    int newRem = (j * 10 + digit) % n;
                    nextDp[newRem] = (nextDp[newRem] + dp[j]) % MOD;
                }
            }

            dp = nextDp;
        }

        return (int) dp[0];
    }
}