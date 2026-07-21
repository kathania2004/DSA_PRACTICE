class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        int[] freq = new int[128];

        // Store frequency of characters required from t
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0;
        int right = 0;

        int required = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char r = s.charAt(right);

            // If r is still needed
            if (freq[r] > 0) {
                required--;
            }

            // Add r to the window
            freq[r]--;

            right++;

            // Current window contains all characters of t
            while (required == 0) {

                // Update minimum window
                if (right - left < minLen) {

                    minLen = right - left;
                    start = left;
                }

                char l = s.charAt(left);

                // Remove l from the window
                if (freq[l] >= 0) {
                    required++;
                }

                freq[l]++;

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}