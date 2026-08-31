class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,diary,res);
        return res;
    }
    static void backtrack(int[] nums,int idx,List<Integer> diary,List<List<Integer
    >> res){
        //base case
        res.add(new ArrayList<>(diary));

        for(int i = idx;i < nums.length;i++){
            //skip duplicate choices at same level
            if(i > idx && nums[i] == nums[i - 1]){
                continue;
            }
            //choose
            diary.add(nums[i]);

            //recursion
            backtrack(nums,i + 1,diary,res);
            //backtrack
            diary.remove(diary.size() - 1);
        }
    }
}