class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num :  nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int operation = 0;

        for(Integer value : map.values()){
            if(value == 1){
                return -1;
            }
            operation += (value + 2) / 3;
        }
        return operation;
    }
}