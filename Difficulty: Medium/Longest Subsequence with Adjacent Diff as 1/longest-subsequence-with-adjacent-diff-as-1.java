class Solution {
    public int longestSubseq(int[] arr) {
        int maxVal = 0;
        for (int num : arr) {
            maxVal = Math.max(maxVal, num);
        }

        int[] dp = new int[maxVal + 2];
        int maxLen = 0;

        for (int num : arr) {
            int left = num > 0 ? dp[num - 1] : 0;
            int right = dp[num + 1];

            dp[num] = Math.max(left, right) + 1;
            maxLen = Math.max(maxLen, dp[num]);
        }

        return maxLen;
    }
}