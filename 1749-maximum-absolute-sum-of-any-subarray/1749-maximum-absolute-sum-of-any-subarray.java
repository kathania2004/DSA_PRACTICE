class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int re = absolute(nums);
        int best = nums[0];
        int ans = nums[0];
        int newans = nums[0];
        for(int i = 1; i < nums.length;i++){
            best = Math.max(best + nums[i],nums[i]);
            ans = Math.max(ans,best);
        }
        newans = Math.max(re,ans);
        return newans;
    }
    static int absolute(int[] nums) {

        int best = nums[0];
        int ans = nums[0];
        for(int i = 1;i < nums.length;i++){
            int c1 = best + nums[i];
            int c2 = nums[i];
            best = Math.min(c1,c2);
            ans = Math.min(ans,best);
        }
        return Math.abs(ans);
    }
}