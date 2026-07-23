class Solution {
    public int maximumSum(int[] nums) {
         int nodeletion = nums[0];
    int onedeletion = nums[0];
    int ans = nums[0];

    for (int i = 1; i < nums.length; i++) {

        // Save the previous value
        int deletecurrent = nodeletion;

        // No deletion
        nodeletion = Math.max(nodeletion + nums[i], nums[i]);

        // Either:
        // 1. Delete current element
        // 2. Deletion already happened earlier
        onedeletion = Math.max(deletecurrent,
                               onedeletion + nums[i]);

        ans = Math.max(ans, Math.max(nodeletion, onedeletion));
    }

    return ans;
    }
}