class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int result = 0;
        Arrays.sort(nums);
        
        for(int i = 1 ; i < n;i++){
            if(nums[i] <= nums[i - 1]){
                result += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1; 
            }

        }
        return result;
    }
}