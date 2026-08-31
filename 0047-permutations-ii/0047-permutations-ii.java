class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,used,diary,res);
        return res;
    }
    static void backtrack(int[] nums,boolean[] used,List<Integer> diary,List<List<Integer>> res){
        if(diary.size() == nums.length){
            res.add(new ArrayList<>(diary));
            return;
        }

        for(int i  = 0;i < nums.length;i++){

            //already used 
            if(used[i]){
                continue;
            }

            //skip duplicate choices at the same level
            if(i > 0 && nums[i] == nums[i - 1] && !used[i -1]){
                continue;
            }

            //choose
            diary.add(nums[i]);
            used[i] = true;

            //recurse
            backtrack(nums,used,diary,res);

            //backtrack
            diary.remove(diary.size() - 1);
            used[i] = false;  
        }
    }
}