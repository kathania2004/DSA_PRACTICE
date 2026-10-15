class Solution {
    public int sumCounts(List<Integer> nums) {
        return distinctElements(nums,0);
    }
    private int distinctElements(List<Integer> nums,int start){
        if(start == nums.size()){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        int currentSum = extend(nums,start,set);

        return currentSum + distinctElements(nums,start + 1);
    }
    private int extend(List<Integer> nums,int i,HashSet<Integer> set){
        if(i == nums.size()){
            return 0;
        }

        set.add(nums.get(i));

        int distinct = set.size();
        int contribution = distinct * distinct;

        return contribution + extend(nums,i + 1,set);
    }
}