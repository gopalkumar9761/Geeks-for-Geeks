class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;
        long[] prefix = new long[n];

        // Step 1: Compute prefix sum of sizes of each interval
        long totalMarks = 0;
        for (int i = 0; i < n; i++) {
            totalMarks += (r[i] - l[i] + 1);
            prefix[i] = totalMarks;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        // Step 2: Answer each query using binary search
        for (int q : rank) {
            int low = 0, high = n - 1;
            int idx = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (prefix[mid] >= q) {
                    idx = mid;
                    high = mid - 1; // Try to find a smaller index on the left
                } else {
                    low = mid + 1;
                }
            }

            // Step 3: Calculate the actual mark using the found interval index
            long diff = prefix[idx] - q;
            int mark = r[idx] - (int)diff;
            ans.add(mark);
        }

        return ans;
    }
}