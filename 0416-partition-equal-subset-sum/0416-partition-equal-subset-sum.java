class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int totalSum = 0;

        for(int num : nums){
            totalSum = totalSum + num;
        }

        if(totalSum % 2 != 0){
            return false;
        }
        int target = totalSum / 2;

        Boolean[][] dp = new Boolean[n][target + 1];

        return solve(nums,0,target,dp);
    }

    private boolean solve(int[] nums,int index,int target,Boolean[][] dp){
        if(target == 0){
            return true;
        }
        if(index == nums.length || target < 0){
            return false;
        }

        if(dp[index][target] != null){
            return dp[index][target];
        }

        //choice
        boolean take = solve(nums,index + 1,target - nums[index],dp);

        boolean notTake = solve(nums,index + 1,target,dp);

        dp[index][target] = take || notTake;

        return dp[index][target];
    }
}