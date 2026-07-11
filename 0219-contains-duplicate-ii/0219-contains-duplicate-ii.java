class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length;i++){
            //remove the elements that are not no longer available
            if(i > k){
                set.remove(nums[i - k - 1]);
            } 
            //check current element exists in the window or not
            if(set.contains(nums[i])){
                return true;
            }
            //if current element no there then add it
            set.add(nums[i]);
        }
        return false;
    }
}