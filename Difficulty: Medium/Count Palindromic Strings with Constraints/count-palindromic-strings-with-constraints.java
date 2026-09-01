class Solution {
    public int palindromicStrings(int n, int k) {
        long MOD = 1000000007;
        long totalCount = 0;

        for (int len = 1; len <= n; len++) {
            int distinctNeeded;
            if (len % 2 == 0) {
                distinctNeeded = len / 2;
            } else {
                distinctNeeded = (len / 2) + 1;
            }

            // If the required distinct characters exceed available k, no such palindrome can be formed
            if (distinctNeeded > k) {
                continue;
            }

            // Calculate P(k, distinctNeeded) % MOD
            long count = 1;
            for (int i = 0; i < distinctNeeded; i++) {
                count = (count * (k - i)) % MOD;
            }

            totalCount = (totalCount + count) % MOD;
        }

        return (int) totalCount;
    }
}