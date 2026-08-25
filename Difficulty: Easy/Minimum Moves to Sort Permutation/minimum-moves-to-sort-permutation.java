class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        int[] count = new int[n + 1];
        
        // Compute longest consecutive increasing subsequence
        for (int x : arr) {
            if (x > 0 && x <= n && count[x - 1] != 0) {
                count[x] = count[x - 1] + 1;
            } else {
                count[x] = 1;
            }
        }
        
        int longest = 0;
        // Find maximum subsequence length
        for (int i = 0; i <= n; ++i) {
            longest = Math.max(longest, count[i]);
        }
        
        return n - longest;
    }
}