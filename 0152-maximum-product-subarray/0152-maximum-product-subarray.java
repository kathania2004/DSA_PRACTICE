class Solution {
    public int maxProduct(int[] nums) {
        int maxend = nums[0];
        int minend = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int c1 = nums[i];
            int c2 = maxend * nums[i];
            int c3 = minend * nums[i];

            maxend = Math.max(c1, Math.max(c2, c3));

            minend = Math.min(c1, Math.min(c2, c3));

            ans = Math.max(ans, maxend);
        }
        return ans;
    }
}