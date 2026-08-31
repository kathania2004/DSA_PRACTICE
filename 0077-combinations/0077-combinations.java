class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();
        backtrack(1,n,k,diary,res);
        return res;
    }
    static void backtrack(int start,int n,int k,List<Integer> diary,List<List<Integer>> res){
        if(diary.size() == k){
            res.add(new ArrayList<>(diary));
            return;
        }

        for(int i = start;i <= n;i++){

            //choice 1 add ther element
            diary.add(i);

            backtrack(i + 1,n,k,diary,res);

            diary.remove(diary.size() - 1);
        }
    }
}