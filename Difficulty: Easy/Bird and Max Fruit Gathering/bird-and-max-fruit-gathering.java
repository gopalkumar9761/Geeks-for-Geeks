class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        int currentSum = 0;

        for (int i = 0; i < m; i++) {
            currentSum += arr.get(i);
        }

        int maxSum = currentSum;

        for (int i = 1; i < n; i++) {
            currentSum = currentSum - arr.get(i - 1) + arr.get((i + m - 1) % n);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}