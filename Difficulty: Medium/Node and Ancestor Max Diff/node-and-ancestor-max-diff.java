class Solution {
    int maxDiff(Node root) {
        if (root == null) return 0;
        return solve(root).maxDiff;
    }

    private Result solve(Node root) {
        if (root == null) {
            return new Result(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        if (root.left == null && root.right == null) {
            return new Result(root.data, root.data, Integer.MIN_VALUE);
        }

        Result leftRes = solve(root.left);
        Result rightRes = solve(root.right);

        int minVal = root.data;
        int maxVal = root.data;
        int maxDiffVal = Integer.MIN_VALUE;

        if (root.left != null) {
            minVal = Math.min(minVal, leftRes.minVal);
            maxVal = Math.max(maxVal, leftRes.maxVal);
            maxDiffVal = Math.max(maxDiffVal, Math.max(root.data - leftRes.minVal, leftRes.maxDiff));
        }

        if (root.right != null) {
            minVal = Math.min(minVal, rightRes.minVal);
            maxVal = Math.max(maxVal, rightRes.maxVal);
            maxDiffVal = Math.max(maxDiffVal, Math.max(root.data - rightRes.minVal, rightRes.maxDiff));
        }

        return new Result(minVal, maxVal, maxDiffVal);
    }

    private static class Result {
        int minVal;
        int maxVal;
        int maxDiff;

        Result(int minVal, int maxVal, int maxDiff) {
            this.minVal = minVal;
            this.maxVal = maxVal;
            this.maxDiff = maxDiff;
        }
    }
}