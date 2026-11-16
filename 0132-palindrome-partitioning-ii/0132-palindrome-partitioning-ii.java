class Solution {
    boolean[][] dp;

    public int minCut(String s) {
        int n = s.length();

        dp = new boolean[n][n];

        // Single characters are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Build palindrome DP
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (l == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        // Minimum cuts DP
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {

            if (dp[0][i]) {
                arr[i] = 0;
            } else {
                arr[i] = Integer.MAX_VALUE;

                for (int k = 0; k < i; k++) {

                    if (dp[k + 1][i]) {
                        arr[i] = Math.min(arr[i], 1 + arr[k]);
                    }
                }
            }
        }

        return arr[n - 1];
    }
}