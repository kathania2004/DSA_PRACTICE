class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();

        backtrack(candidates,0,diary,0,res,target);
        return res;
    }
    static void backtrack(int[] a,int i,List<Integer> diary,int sum,List<List<Integer>> res,int target){
        if(sum == target){
            res.add(new ArrayList<>(diary));
            return;
        }

        if(i >= a.length || sum > target){
            return;
        }

        //choice1: take
        if(sum + a[i] <= target){
            diary.add(a[i]);

            backtrack(a,i,diary,sum + a[i],res,target);
            diary.remove(diary.size() - 1);
        }
        //choice2: skip
        backtrack(a,i + 1,diary,sum,res,target);
    }
}