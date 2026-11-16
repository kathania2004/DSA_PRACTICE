class Solution {
    public List<List<String>> partition(String s) {
       int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // Single characters are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Build palindrome DP table
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

        List<List<String>> result = new ArrayList<>();
        List<String> currPartition = new ArrayList<>();

        solve(s, 0, currPartition, dp, result);

        return result;
    }

    private void solve(String s, int i,
                       List<String> currPartition,
                       boolean[][] dp,
                       List<List<String>> result) {

        if (i == s.length()) {
            result.add(new ArrayList<>(currPartition));
            return;
        }

        for (int j = i; j < s.length(); j++) {

            if (dp[i][j]) {

                currPartition.add(s.substring(i, j + 1));

                solve(s, j + 1, currPartition, dp, result);

                currPartition.remove(currPartition.size() - 1);
            }
        }
    }

}