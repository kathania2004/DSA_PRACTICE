class Solution {
    public int maxSubArray(int[] nums) {
        int best = nums[0];
        int ans = nums[0];
        for(int i =1;i < nums.length;i++){
            int c1 = best + nums[i];
            int c2 = nums[i];
            best = Math.max(c1,c2);
            ans = Math.max(ans,best);
        }
        return ans;   
    }
}