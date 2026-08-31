class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();

        backtrack(nums,0,diary,res);
        return res;
    }
    static void backtrack(int[] nums,int idx, List<Integer> diary, List<List<Integer>> res){
        //base case
        if(idx == nums.length){
            res.add(new ArrayList<>(diary));
            return;
        }

        //chioce1: include num at indx

        diary.add(nums[idx]);
        backtrack(nums,idx + 1,diary,res);

        //remove the nums
        diary.remove(diary.size() - 1);

        //choice 2 not include the num at idx
        backtrack(nums,idx + 1,diary,res);
    }
}