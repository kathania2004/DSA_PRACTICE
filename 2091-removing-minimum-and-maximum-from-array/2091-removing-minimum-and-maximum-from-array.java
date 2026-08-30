class Solution {
    public int minimumDeletions(int[] nums) {
        int minIndex = 0;
        int maxIndex = 0;
        

        //find min and max index
        for(int i = 0;i < nums.length;i++){

            if(nums[i] < nums[minIndex]){
                minIndex = i;
            }

            if(nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
            int left = Math.min(minIndex,maxIndex);
            int right = Math.max(minIndex,maxIndex);

            int fromFront = right + 1;
            int fromBack = nums.length - left;

            int fromBoth = (left + 1) + (nums.length - right);

            return Math.min(fromFront,Math.min(fromBack,fromBoth));
    }
}