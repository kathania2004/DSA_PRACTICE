class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums,used,diary,res);
        return res;
    }
    static void backtrack(int[] nums,boolean[] used,List<Integer> diary,List<List<Integer>> res){

        if(diary.size() == nums.length){
            res.add(new ArrayList<>(diary));
            return;
        }
        for(int i = 0;i < nums.length;i++){

            //skip if already used
            if(used[i]){
                continue;
            }

            //choose
            diary.add(nums[i]);
            used[i] = true;
            backtrack(nums,used,diary,res);
            diary.remove(diary.size() - 1);
            used[i] = false;
        }
    }
}