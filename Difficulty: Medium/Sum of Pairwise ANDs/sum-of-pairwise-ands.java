class Solution {
    public long pairAndSum(int[] arr) {
        long totalSum = 0;

        for (int bit = 0; bit < 32; bit++) {
            long count = 0;

            for (int num : arr) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            long pairs = (count * (count - 1)) / 2;
            totalSum += pairs * (1L << bit);
        }

        return totalSum;
    }
}