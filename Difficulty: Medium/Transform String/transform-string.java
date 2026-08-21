class Solution {
    int transform(String s1, String s2) {
        // code here
        if (s1.length() != s2.length()) {
            return -1;
        }

        int n = s1.length();
        int[] count = new int[256];

        for (int i = 0; i < n; i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return -1;
            }
        }

        int i = n - 1;
        int j = n - 1;
        int operations = 0;

        while (i >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j--;
            } else {
                operations++;
            }
            i--;
        }

        return operations;
    }
}