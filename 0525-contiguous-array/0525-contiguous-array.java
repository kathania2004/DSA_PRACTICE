class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int zero = 0;
        int one = 0;
        int n = nums.length;
        int res = 0;
        map.put(0,-1);
        for(int i = 0;i < n;i++){
            if(nums[i] == 0){
                zero++;
            }else{
                one++;
            }

            int diff = zero - one;
            if(map.containsKey(diff)){
                int start = map.get(diff);
                int len = i - start;
                res = Math.max(res,len);
            }else{
                map.put(diff,i);
            }
        }
        return res;
    }
}