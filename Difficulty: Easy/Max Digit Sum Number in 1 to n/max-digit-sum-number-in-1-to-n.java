class Solution {
    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public int findMax(int n) {
        int ans = n;
        int maxSum = digitSum(n);

        int x = n;
        long b = 1;

        while (x > 0) {
            long candidateVal = (long) (x - 1) * b + (b - 1);

            if (candidateVal >= 1 && candidateVal <= n) {
                int candidate = (int) candidateVal;
                int sum = digitSum(candidate);

                if (sum > maxSum || (sum == maxSum && candidate > ans)) {
                    maxSum = sum;
                    ans = candidate;
                }
            }

            x /= 10;
            b *= 10;
        }

        return ans;
    }
}