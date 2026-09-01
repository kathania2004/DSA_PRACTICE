class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,diary,res);
        return res;
    }
    static void backtrack(int[] candidates,int target,int idx,List<Integer> diary,List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(diary));
            return;
        }

        for(int i = idx;i < candidates.length;i++){
            //skip duplicate at the same level
            if(i > idx && candidates[i] == candidates[i - 1]){
                continue;
            }

            if(candidates[i] > target){
                break;
            }

            //choice 1 add
            diary.add(candidates[i]);
            
            //move to i + 1 because each number can be used once 
            backtrack(candidates,target - candidates[i],i + 1,diary,res);

            diary.remove(diary.size() - 1);

        }
    }
}