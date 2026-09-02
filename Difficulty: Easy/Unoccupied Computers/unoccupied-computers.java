class Solution {
    public int solve(int n, String s) {
        int rejectedCount = 0;
        int occupied = 0;

        // 0 = Not seen, 1 = Currently using computer, 2 = Rejected/Left
        int[] status = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'A';

            if (status[charIndex] == 0) { // First occurrence (Arrival)
                if (occupied < n) {
                    occupied++;
                    status[charIndex] = 1; // Customer gets a computer
                } else {
                    rejectedCount++;
                    status[charIndex] = 2; // Customer is rejected
                }
            } else if (status[charIndex] == 1) { // Second occurrence (Departure of served customer)
                occupied--;
                status[charIndex] = 2;
            }
            // If status[charIndex] == 2, it's the second occurrence of a rejected customer, so we do nothing.
        }

        return rejectedCount;
    }
}